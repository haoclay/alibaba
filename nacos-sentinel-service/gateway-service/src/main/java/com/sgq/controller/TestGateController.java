package com.sgq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestGateController {

    @RequestMapping("/gate")
    public String gate(){
        System.out.println("1111");
        return "page/index";
    }
}
