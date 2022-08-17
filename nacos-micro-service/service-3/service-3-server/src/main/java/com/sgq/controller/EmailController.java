package com.sgq.controller;

import com.alibaba.fastjson.JSONObject;
import com.sgq.service.IEmailService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.ConcurrentHashMap;

@RestController
public class EmailController {
    @Reference
    private IEmailService emailService;

    @RequestMapping("/sendEmail")
    public String sendEmail(@RequestParam String target,
                            @RequestParam String title,
                            @RequestParam String content){
        ConcurrentHashMap map = new ConcurrentHashMap(){{
            put("mail_target",target);
            put("mail_title",title);
            put("mail_content",content);
        }};
        emailService.send(map);
        JSONObject json  = new JSONObject();
        json.put("state","1");
        return json.toJSONString();
    }

    @RequestMapping("/emailPage")
    public ModelAndView emailPage(){
        ModelAndView mv = new ModelAndView("/email/page/email");
        return mv;
    }
}
