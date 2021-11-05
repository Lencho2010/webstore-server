package com.geoway.webstore;

import com.geoway.webstore.util.IDWorker;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

/**
 * @author Lencho
 * @create 2021-08-18 19:29
 */
@EnableAsync
@SpringBootApplication
@EnableSwagger2Doc
public class LenApplication {
    public static void main(String[] args) {
        SpringApplication.run(LenApplication.class, args);
    }

    @Bean
    public IDWorker getBean(){
        return new IDWorker(1,1);
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
