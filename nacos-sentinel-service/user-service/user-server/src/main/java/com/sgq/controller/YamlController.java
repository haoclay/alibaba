package com.sgq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YamlController {
    @Value("${user.username}")
    private String username;

    @Value("${user.password}")
    private String password;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @GetMapping("/getParamsByValue/{id}")
    public String getParamsByValue(@PathVariable("id") String id){

            return "username:"+username + "--->password:"+password +id ;
    }

    @GetMapping("/getParamsByResources")
    public String getParamsByResources(){
       return applicationContext.getEnvironment().getProperty("user.username");
    }
}