package com.sgq.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sgq.mapper.GoodsMapper;
import com.sgq.pojo.Goods;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@DubboService
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> findAll() {
        return goodsMapper.selectList(new QueryWrapper<Goods>());
    }

    @Override
    public Integer removeByIds(List<Integer> ids) {
        return goodsMapper.deleteBatchIds(ids);
    }

    @Override
    public Integer alterById(Goods goods) {
        return goodsMapper.updateById(goods);
    }

    @Override
    public Integer addOne(Goods goods) {
        return goodsMapper.insert(goods);
    }
}