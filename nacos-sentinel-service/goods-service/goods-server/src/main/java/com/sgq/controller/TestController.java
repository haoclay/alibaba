package com.sgq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/testGoods")
    public String testGoods(){
        return "商品啊~";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "商品首页~";
    }
}