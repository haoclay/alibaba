package com.sgq.service;

import org.apache.dubbo.config.annotation.Reference;

import java.util.Map;


@org.apache.dubbo.config.annotation.Service
public class FourthServiceImpl implements FourthService {
    @Reference
    private IEmailService emailService;


    @Override
    public void sendEmailByQQ(Map mailMap) {
        emailService.send(mailMap);
    }
}
