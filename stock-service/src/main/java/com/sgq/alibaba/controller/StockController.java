package com.sgq.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : sgq
 * Date : 2021/1/18 20:37
 */
@RestController
@RequestMapping("/stock")
public class StockController {

     @GetMapping(value = "/deduct/{productId}/{stockCount}")
    public String deductStock(@PathVariable("productId") Long productId,
                              @PathVariable("stockCount") Integer stockCount){

         return "productId:"+productId+"stockCount:"+stockCount+"库存减1";

    }
}
