package com.geoway.webstore.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.geoway.webstore.anno.ResponseResult;
import com.geoway.webstore.util.StringUtil;
import com.geoway.webstore.util.XmlUtil;
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
import java.util.List;

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
        File xmlFile = new File("templates\\config.xml");
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
    @Qualifier("masterJdbcTemplate")
    protected JdbcTemplate jdbcTemplate;

    @GetMapping("/testSql")
    public void testSql(){
        String sql = "SELECT COUNT(*) FROM payment;";
        long forLong = jdbcTemplate.queryForObject(sql,Long.class);
        System.out.println(forLong);
    }
}
