package com.sgq.service;

import com.sgq.pojo.Goods;

import java.util.List;

public interface IGoodsService {

    List<Goods> findAll();

    Integer removeByIds(List<Integer> ids);

    Integer alterById(Goods goods);

    Integer addOne(Goods goods);

}