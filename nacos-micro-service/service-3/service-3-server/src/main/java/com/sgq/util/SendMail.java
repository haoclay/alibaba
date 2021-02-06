package com.sgq.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class SendMail {
      private static  Properties properties = new Properties();
      private static String host_mail = "1853737225@qq.com";

      static {
        properties.setProperty("mail.host","smtp.qq.com");
        properties.setProperty("mail.transport.protocol","smtp");
        properties.setProperty("mail.smtp.auth","true");

     }

    public static void main(String[] args) throws MessagingException {
        Scanner scanner = new Scanner(System.in);
          while (true){
              System.out.println("请输入对方邮箱");
              String mail_target =scanner.next();
              System.out.println("请输入邮箱主题");
              String mail_title =scanner.next();
              System.out.println("请输入发送内容");
              String mail_content =scanner.next();
              Map<String,String> map = new HashMap(){{
                  put("mail_target",mail_target);
                  put("mail_title",mail_title);
                  put("mail_content",mail_content);
              }};
              send(map);
          }


    }


    public static void send(Map<String,String> mailMap) throws MessagingException {

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(host_mail,"azwzwwiazuladdgf");
            }
        });
        Transport transport =session.getTransport();
        transport.connect("smtp.qq.com",host_mail,"azwzwwiazuladdgf");
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(host_mail));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(mailMap.get("mail_target")));
        message.setSubject(mailMap.get("mail_title"));
        message.setContent(mailMap.get("mail_content"),"text/html;charset=utf-8");
        transport.sendMessage(message,message.getAllRecipients());
        System.out.println("successful");


    }
}
