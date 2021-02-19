package com.sgq.service;

import com.sgq.api.IEmailService;
import com.sgq.util.SendMail;

import javax.mail.MessagingException;
import java.util.Map;

@org.apache.dubbo.config.annotation.Service
public class EmailServiceImpl implements IEmailService {
    @Override
    public void send(Map mailMap)  {
        try {
            SendMail.send(mailMap);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
