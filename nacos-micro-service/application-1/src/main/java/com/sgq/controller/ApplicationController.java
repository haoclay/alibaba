package com.sgq.controller;



import com.sgq.api.FirstService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    @Reference
    private FirstService firstService;

    @RequestMapping(value = "doService")
    public String doService(){
        String str = firstService.doFirst();
        return "application-1 |"+str;
    }
}
