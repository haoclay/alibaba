package com.sgq.service;

import com.sgq.api.FirstService;


@org.apache.dubbo.config.annotation.Service
public class FirstServiceImpl implements FirstService {
    @Override
    public String doFirst() {
        return "service-1-api-implements";
    }
}
