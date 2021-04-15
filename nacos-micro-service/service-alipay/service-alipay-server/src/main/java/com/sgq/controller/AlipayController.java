package com.sgq.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : SGQ
 * @create 2021/4/13 16:21
 */
@Controller
public class AlipayController {
    private String app_id="2021000117638167";
    private String private_key="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC3Prn1mYUKZkwGtw+YJZ2b4NlqInMc6QjSjAioKv4R0iBjF9iCARuKMEmYlBTtnLiP9h574msl+N1ZhlbmR0KMTUJ5+q2JbfbgCNezd7+sBRxEdUak/ABQ44RFqRJK22jOOV2Rhy+ZHDWK3XJjghcpsN4WXUL6WkE93m9CMI2SYeM9ptY0QDU8ahZ+JVwiHFENBtDCwz3JmHyhq/NZ75HRPJ/jZXtS6Qjokw+PDVUm4IvsXcCi0DA/jnETiGtLMKkZDeFmYUSCrUwTq65QQ1m4I6bpO/1XAebyQP+DsKmcptAh6lO6kHCccckLOURKRhP9UJzz3O44T9cP4UmtnBl3AgMBAAECggEAaFWzxg5CPPigAxbKL0QDqFRvFkpFJsnctxz6dN39yaHNxP43zVXaG2WBEfoGrIAWagmls73oajd3uNiPtBAQ6Re4aQF9O4m8DjWas1nUbZp/TM9FiPzfJS9WCd/JRYwF8Z2iFBFX3aK9LbMGxXe1voww96TkVO18xkBXMuW4RgazGJjSrWiQ8aJV10HkYaImvAHwcinQR1qo9RyxzFN/7ivcD9xvydEaAe4L3GGJjWXArf1Iux3RUMUyrl8wASID0DNICvdAkLMU5XVKoA9Y+fcNk0PCR9fudJJJnLPDMNoeG7jG9ApvS2CGn4Uo4JVvUYiL0chqTz12sx/fNwaEaQKBgQD5wWS+TIop93RbpEZFjtqs+wzy1nG6IfdcvB3nOcpWg2tnGbUW0qn0kfBS5n0B9rL0wbOnxcoQ9bOnO2UF+sO5QGhlOUrC9dS3B/iRXMFlqnwfOi0Sb28NgxEnSwikVQGnfWbHNGgbwx2KuEn28mRJQjjg2h8aVRo01xUKYtbrPQKBgQC7057YemTf+KfFSCYt5bkUc4Ad/GJKxCtnJss64v0hVRO/Id7hvqZ++l5IwQhQ1eKCLp+KbDS1gJIQXc8zcyO8UMQ37tOlj7PRyrVwL/gxqlrr/TtEXk6bFSF2toKFlLiL/aV7tc7Y9My/k2CGePfV3ZvfZwmL6M8qXVxGRRkywwKBgQCnXhAy7nvQL8HL/8QPrPGh5gMBYO+JemWXwYCQiUusuhjpWHLgPoAiIwJXq5muDTJTjtLj5UnKH70qnkTOwwMSS7Up0EDncXIAzdinIO+BP8Q58PRvXDmhZmnCWSgLZ+PZ59FOQTJbGF/drC30zO6joTsYg1NAhDMxoci50w6PSQKBgHTresoPBpRVWTp5eyq/AcM1Ut9XqGgaTVpcz83MVv5U04H7N58W6tXITMDFSMPpIKMhGrc0PGtvqXz+qGjCl9A2Bq86wA0jszA5G1DGy50/CnI0pJweiJgJQ1d+rSkyNt8N+eFUf3qWiI4I0+FhlAVReiJLJaouNieNDk+/27u5AoGBAOzJ7L5cZsrkZed9EyORV3s1tGNYjhCxWSabzXpeUHVvWKk0hAQQVzNYWIn0EKgI8XcPsnbKOhG72O/uLTldsLOP2EOOdRYegsavB0zrZEqHL7BGAxpEbcks+02zFAVzFhR3AXPnJPUG6ugYDKoPXxVaGqO+XxvYMoJ3KckmW09C";
    private String alipay_public_key="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtI/yY4Qf8YkbmWCa9XT+BardXDloDtcw/8r1yB3eYNf5sJ7JrLznsRYFBf2Swok5D4cEbsLnItw0le2ZNG1/+aMq02vCkF6KpkGVNB9QgNLbcVBV02P5UZ5KVrlTGAhH0EB8BLIJKK45azl0K6cWr9Asq8H7tN1HKxbUV4RifyvGLzKt3uvhw5qNSXjGC6q3RSNESW3oiqS1jtOnG3IhWwFhYz7sP6YE4Ex5K/L58o87E4J/A0LgiECGYXbVz4mvjj5rd9awvQcuvdFpyHLeiBLcrQ5uTVyun9jT4ZatMw48CRoFEI0zvhnG3f1MSBHo81ZQkMEi1Vb1AIZv5n344QIDAQAB";
    private String charset="utf-8";
    private String server_url="https://openapi.alipaydev.com/gateway.do";
    private String sign_type="RSA2";
    private String format="json";


    @GetMapping("/alipayTest")
    public void  alipayTest(HttpServletResponse response) throws AlipayApiException, IOException {

       AlipayClient alipayClient = new DefaultAlipayClient(server_url,app_id,private_key,format,charset,alipay_public_key,sign_type);
       AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
       request.setBizContent("{" +
               "\"out_trade_no\":\"20150320010101001\"," +
               "\"total_amount\":88.88," +
               "\"subject\":\"Iphone6 16G\"," +
               "\"product_code\":\"QUICK_WAP_PAY\" " +
               "  }");
       String form = "";
       try {
           form = alipayClient.pageExecute(request).getBody();
       }catch (AlipayApiException e){
           System.out.println( e.getErrMsg());
       }
       response.setContentType("text/html;charset="+charset);
       response.getWriter().write(form);
       response.getWriter().flush();
       response.getWriter().close();


     }

}
