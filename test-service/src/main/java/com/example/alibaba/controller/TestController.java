package com.example.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * Author : sgq
 * Date : 2021/1/19 14:03
 */
@RefreshScope
public class TestController {
    @Value("${value}")
    private String value;
    public String getValue(){
        return this.value;
    }
}
