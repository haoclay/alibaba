package com.example.otherack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AckController {
    @RequestMapping("/ack")
    public String ack(){
       return "page/ack";
    }
}
