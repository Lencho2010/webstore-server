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
//@Data
//@Configuration
//@ConfigurationProperties(prefix = "second.datasource.druid")
public class DataSourceConfig {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    //    @Primary
    @Bean(name = "secondDataSource")
    public DataSource getMasterDataSource() throws SQLException {
        DruidDataSource druid = new DruidDataSource();

        // 配置基本属性
        druid.setDriverClassName(driverClassName);
        druid.setUsername(username);
        druid.setPassword(password);
        druid.setUrl(url);
        druid.setTestWhileIdle(false);
        System.out.println(driverClassName);
        return druid;
    }

    @Bean(name = "secondJdbcTemplate")
    public JdbcTemplate primaryTemplate(@Qualifier("secondDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
