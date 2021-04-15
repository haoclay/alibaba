package com.sgq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : SGQ
 * @create 2021/3/19 16:53
 */
@RestController
public class ConfigParameterController {
    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @GetMapping("/getConfig")
    public String getConfig(){
        String firstname = applicationContext.getEnvironment().getProperty("person.name.firstname");
        String lastname = applicationContext.getEnvironment().getProperty("person.name.lastname");
        String address = applicationContext.getEnvironment().getProperty("person.address");
        String age = applicationContext.getEnvironment().getProperty("person.age");
        return firstname+"->"+lastname+"->"+address+"->"+age;

    }


}
