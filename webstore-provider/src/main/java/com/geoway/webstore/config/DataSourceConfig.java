package com.geoway.webstore.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author: Lencho
 * @CreateTime: 2021/11/4 21:38
 * @Description:
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "master.datasource.druid")
public class DataSourceConfig {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    //    @Primary
    @Bean(name = "masterDataSource")
    public DataSource getMasterDataSource() throws SQLException {
        DruidDataSource druid = new DruidDataSource();

        // 配置基本属性
        druid.setDriverClassName(driverClassName);
        druid.setUsername(username);
        druid.setPassword(password);
        druid.setUrl(url);
        System.out.println(driverClassName);
        return druid;
    }

    @Bean(name = "masterJdbcTemplate")
    public JdbcTemplate primaryTemplate(@Qualifier("masterDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
