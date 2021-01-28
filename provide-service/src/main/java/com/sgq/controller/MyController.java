package com.sgq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : sgq
 * Date : 2021/1/27 16:57
 */
@RestController
public class MyController {

    @GetMapping(value = {"/service","/service.do"})
    public String service(){

        return "from_provider";
    }

}
