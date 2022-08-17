package com.sgq.controller;

import com.sgq.service.IGoodsService;
import com.sgq.pojo.Goods;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods/cart")
public class DoubleGoodsController {

    @DubboReference
    private IGoodsService goodsService;

    @RequestMapping("/show")
    public List<Goods> show(){
        return goodsService.findAll();
    }
}
