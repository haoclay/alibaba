package com.sgq.nacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : sgq
 * Date : 2021/1/21 20:11
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
public class MySpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringbootApplication.class,args);
    }

    @Value("${test.a}")
    String a;
    @Value("${test.b}")
    String b;

    @Autowired
    ConfigurableApplicationContext applicationContext;

    @GetMapping("/getConfig.do")
    public String getConfig() {
        return a ;
    }

    @GetMapping("/getAutoUpdateConfig.do")
    public String getAutoUpdateConfig() {


            return applicationContext.getEnvironment().getProperty("test.a");


    }
}
