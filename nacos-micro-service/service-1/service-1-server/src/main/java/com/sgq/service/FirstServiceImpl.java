package com.sgq.service;


@org.apache.dubbo.config.annotation.Service
public class FirstServiceImpl implements FirstService {
    @Override
    public String doFirst() {
        return "service-1-api-implements";
    }
}
