package com.example.sentinelservice.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class FlowController {
    private static final String RESOURCE_NAME = "flow";

    @RequestMapping("/flow")
    @SentinelResource(value = RESOURCE_NAME,blockHandler = "flowBlockHandler")
    public String flow(){
        return "正常访问";
    }

    public String flowBlockHandler(BlockException e){
        return "限流了~~~";
    }
}