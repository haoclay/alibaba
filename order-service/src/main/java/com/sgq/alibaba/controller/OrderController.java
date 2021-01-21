package com.sgq.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * Author : sgq
 * Date : 2021/1/18 21:28
 */
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/deduct/{productId}/{stockCount}")
    public String deductStock(@RequestParam("productId") Long productId,
                              @RequestParam("stockCount") Integer stockCount){

        return this.restTemplate.getForObject("http://stock-service/stock/deduct"+productId+"/stockCount"+stockCount,String.class);

    }
}
