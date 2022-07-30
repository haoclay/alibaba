package com.example.sentinelservice.controller;


import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DegradeController {

    private static final String DEGRADE_RESOURCE_NAME = "degrade";


    @RequestMapping("/degrade")
    @SentinelResource(value = DEGRADE_RESOURCE_NAME
                      ,entryType = EntryType.IN
                      ,blockHandler = "degradeBlockHandler"
                      ,fallback = "degradeFallback")
    public String degrade(){
       throw new RuntimeException("异常产生");
    }

    public String  degradeBlockHandler(BlockException ex){
        return "熔断降级处理...";
    }
    //定义了degradeFallback并配置了,优先执行degradeFallback
    // 在一分钟内执行2次后2次及以上异常则触发熔断降级服务。后面的10秒内再次调用仍然执行
    //降级服务，10秒以后再调用第一次又抛异常，则直接除服降级服务
    public String  degradeFallback(){
        return "fallback...";
    }



    @PostConstruct
    public void initDegradeRule(){

        //降级规则
        List<DegradeRule> degradeRules = new ArrayList<>();

        DegradeRule rule = new DegradeRule();

        rule.setResource(DEGRADE_RESOURCE_NAME);

        //设置规则侧率:异常数
        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        //触发熔断异常数:2
        rule.setCount(2);
        //触发熔断最小请求数:2
        rule.setMinRequestAmount(2);
        //统计时长:单位: ms  1分钟
        rule.setStatIntervalMs(60*1000);
        //熔断持续时长 10s
        rule.setTimeWindow(10);

        //一分钟内:执行了2次出现了2次异常就会触发熔断
        //熔断持续时长:单位秒
        //一旦触发了熔断，再次请求对应的接口就会直接调用﹑降级方法。
        //10秒过了后--半开状态:恢复接口请求调用，如果第一次请求就异常，再次熔断

        degradeRules.add(rule);

        DegradeRuleManager.loadRules(degradeRules);

    }
}