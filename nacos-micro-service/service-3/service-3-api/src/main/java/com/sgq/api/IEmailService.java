package com.sgq.api;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import java.util.Map;

public interface IEmailService {
    void send(Map mailMap);

}
