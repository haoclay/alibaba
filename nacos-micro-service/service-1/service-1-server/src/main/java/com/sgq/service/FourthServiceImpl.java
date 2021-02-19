package com.sgq.service;

import com.sgq.api.FourthService;
import com.sgq.api.IEmailService;
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
