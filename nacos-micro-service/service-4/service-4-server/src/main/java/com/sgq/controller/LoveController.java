package com.sgq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoveController {

    @RequestMapping("/siyue/love")
    public String lovePage(){
        return "love";
    }
}
