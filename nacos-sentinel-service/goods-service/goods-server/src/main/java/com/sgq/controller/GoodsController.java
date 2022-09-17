package com.sgq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoodsController {

    @RequestMapping("/goods/{id}")
    public String findAll(@PathVariable("id") Integer id){
        return "views/level1/"+id;
    }
}
