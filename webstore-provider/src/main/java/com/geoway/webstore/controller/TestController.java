package com.geoway.webstore.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.entity.ExportWordConfigDetail;
import com.geoway.webstore.entity.SqlItem;
import com.geoway.webstore.entity.TransportTemplate;
import com.geoway.webstore.util.ExportWordUtil;
import com.geoway.webstore.util.StringUtil;
import com.geoway.webstore.util.Transport;
import com.geoway.webstore.util.XmlUtil;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Lencho
 * @CreateTime: 2021/11/4 19:44
 * @Description:
 */
@RestController
@RequestMapping("/test")
@ResponseResult
public class TestController {

    @Value("${template-loader-path}")
    private String templateLoaderPath;

    @GetMapping("/test1")
    public void test1() {
        /*System.out.println(templateLoaderPath);
        System.out.println(this.getClass().getResource("/").getPath());*/

        try {
            //File path3 = new File(ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX).getPath());
            File path3 = new File("templates");
            System.out.println(path3.getAbsolutePath());
            //ResourceUtils.CLASSPATH_URL_PREFIX + "templates"
            File path2 = new File(ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX + "\\templates").getPath());
            if (!path2.exists()) path2 = new File("");
            System.out.println(path2.getAbsolutePath());
            File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "templates");
            System.out.println(file.getPath());

            org.springframework.core.io.Resource classPathResource = new ClassPathResource("templates");
            String path = classPathResource.getFile().getPath();
            System.out.println(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String readFileToString() throws IOException {
        File xmlFile = new File("templates\\aaaa_config.xml");
        if (xmlFile.exists()) {
            System.out.println(xmlFile.getAbsolutePath());

            BufferedReader br = new BufferedReader(new FileReader(xmlFile));
            StringBuilder stringBuilder = new StringBuilder();
            String line = "";
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            br.close();
            String result = stringBuilder.toString();
            /*if (!StringUtil.isEmpty(result))
                System.out.println(result);*/
            return result;
        }
        return "";
    }

    @GetMapping("/testXml")
    public void testXml() throws IOException {
        String xml = readFileToString();
        if (StringUtil.isEmpty(xml)) return;

        JSONObject json = XmlUtil.xml2Json(xml);
        System.out.println(json.toJSONString());
        List<String> lstFile = new ArrayList<>();
        if (json.get("sqlItem") instanceof JSONArray) {
            for (Object j : json.getJSONArray("sqlItem")) {
                String cFile = ((JSONObject) j).toString();
                lstFile.add(cFile);
            }
            System.out.println(lstFile.toString());
        } else {
            String outPath = json.getObject("sqlItem", String.class);
            System.out.println(outPath);
        }
    }


    @Resource
//    @Qualifier("secondJdbcTemplate")
    protected JdbcTemplate jdbcTemplate;

    @GetMapping("/testSql")
    public void testSql() {
        String sql = "SELECT COUNT(*) FROM jctb_task;";
        long forLong = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(forLong);
    }

    @GetMapping("/testXml2")
    public ExportWordConfigDetail testXml2() throws IOException {
        String xml = readFileToString();
        if (StringUtil.isEmpty(xml)) return null;

        JSONObject json = XmlUtil.xml2Json(xml);
        ExportWordConfigDetail exportWordConfigDetail = json.toJavaObject(ExportWordConfigDetail.class);

        System.out.println(exportWordConfigDetail.toString());
        return exportWordConfigDetail;
    }

    @GetMapping("/testXml3")
    public void testXml3() throws IOException {
        this.transportDocTemplate();
    }

    private void transportDocTemplate() {
        //1.根据xml转换为配置对象
        ExportWordConfigDetail configDetail = gainConfigDetail("aaaa_config");

        //2.配置对象中的sql语句带表达式的进行替换
        assert configDetail != null;
        transportSql(configDetail);

        //3.执行sql语句形成map
        Map<String, Object> resultMap = processSql(configDetail);
        //System.out.println(resultMap);

        //4.对word模板进行处理
        processWordTemplate(configDetail, resultMap);
    }

    private String readFileToString(String xmlName) {
        File xmlFile = new File("templates\\" + xmlName + ".xml");
        if (!xmlFile.exists()) {
            return "";
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(xmlFile));
            StringBuilder stringBuilder = new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
            return stringBuilder.toString();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return "";
        }
    }

    private ExportWordConfigDetail gainConfigDetail(String xmlName) {
        String xmlText = readFileToString(xmlName);
        if (StringUtil.isEmpty(xmlText)) return null;

        JSONObject json = XmlUtil.xml2Json(xmlText);
        return json.toJavaObject(ExportWordConfigDetail.class);
    }

    private void transportSql(ExportWordConfigDetail configDetail) {
        //模拟模板中对应的表达式数据
        Map<String, Object> needData = new HashMap<>();
        needData.put("taskName", "2021S205190028");
        TransportTemplate template = new TransportTemplate();

        configDetail.getSqlItem().forEach(item -> {
            template.setTemplate(item.getSql());
            template.setTemplateMap(needData);
            String transformSql = Transport.transform(template);
            item.setSql(transformSql);
        });
    }

    private Map<String, Object> processSql(ExportWordConfigDetail configDetail) {
        Map<String, Object> resultMap = new HashMap<>();
        configDetail.getSqlItem().forEach(item -> {
            String sql = item.getSql();
            Map<String, Object> map = jdbcTemplate.queryForMap(sql);
            resultMap.put(item.getKey(), map);
        });
        return resultMap;
    }

    private void processWordTemplate(ExportWordConfigDetail configDetail, Map<String, Object> dataMap) {
        File templateFile = new File(configDetail.getDocPath());
        String templatePath = templateFile.getParentFile().getAbsolutePath();// templateFile.getAbsolutePath();
        String templateName = templateFile.getName();

        System.out.println(templateName);
        System.out.println(templatePath);
        try {
            File workDirFile = new File(configDetail.getOutPath());
            if (!workDirFile.exists()) workDirFile.mkdirs();

            ExportWordUtil.exportWord(dataMap, templatePath, templateName, configDetail.getOutPath(), "test.docx");
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

}
