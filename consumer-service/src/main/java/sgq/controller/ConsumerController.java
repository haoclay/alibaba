package sgq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgq.client.MyService;

/**
 * Author : sgq
 * Date : 2021/1/27 17:23
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private MyService myService;
    @GetMapping(value = {"/service","/service.do"})
    public String service(){
       return "Consumer_Service" + "||" + myService.service();
    }
}
