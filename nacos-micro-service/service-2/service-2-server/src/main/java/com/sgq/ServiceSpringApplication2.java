package com.sgq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.sgq.dao")
@EnableDiscoveryClient

public class ServiceSpringApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSpringApplication2.class,args);
    }
}
