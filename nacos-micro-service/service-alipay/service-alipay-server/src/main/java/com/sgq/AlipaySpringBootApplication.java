package com.sgq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : SGQ
 * @create 2021/4/13 16:42
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class AlipaySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlipaySpringBootApplication.class);
    }
}
