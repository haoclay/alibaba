package com.example.sentinelservice.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.example.sentinelservice.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
public class HelloController {
    //流控规则和降级规则都定义了，流控规则优先执行
    private static final String RESOURCE_NAME = "hello";
    private static final String USER_RESOURCE_NAME = "user";

    @RequestMapping("/hello")
    public String hello(){
        Entry entry = null;

         try {
             entry = SphU.entry(RESOURCE_NAME);
             String msg = "hello sentinel";
             log.info(msg);
             return msg;
         }catch (BlockException e){
             log.info("block~~~");
             return "被流控了!!!";
         }catch (Exception e){
             Tracer.traceEntry(e,entry);
         }finally {
             if (entry != null){
                 entry.exit();
             }
         }
         return null;
    }

    @PostConstruct
    private static void initFlowRules(){

        List<FlowRule> flowRules = new ArrayList<>();

        FlowRule rule1 = new FlowRule();

        rule1.setResource(RESOURCE_NAME);

        rule1.setGrade(RuleConstant.FLOW_GRADE_QPS);

        rule1.setCount(1);

        flowRules.add (rule1);

        //通过@sentinelResource来定义资源并配置降级和流控的处理方法
        FlowRule rule2 = new FlowRule();
        //设置受保护的资源
        rule2.setResource (USER_RESOURCE_NAME);
        //设置流控规则QPS
        rule2.setGrade ( RuleConstant.FLOW_GRADE_QPS) ;

        //设置受保护的资源阈值
        rule2.setCount(1);

        flowRules.add(rule2);

        //加载配置好的规则
        FlowRuleManager.loadRules(flowRules);

    }

    /**
     *
     * @SentinelResource改善接口中资源定义和被流控降级后的处理方法
     *怎么使用: 1.添加依赖<artifactId>sentinel-annotation-aspectj</artifactId>
     *@return
     *
     * */
    @RequestMapping("/user")
    @SentinelResource(value = USER_RESOURCE_NAME
            ,blockHandler = "blockHandlerForGetUser"
            ,fallback = "fallBackGetUser"
            ,fallbackClass = com.example.sentinelservice.pojo.User.class)
    public User getUser(String id){
        int a  = 1/0 ;
        return new User ("1","正常") ;
    }

    /**
     *注意:
     *1.一定要public
     *2.返回值一定要和源方法保证一致*@param id
     *
     * blockHandler 设置流控降级后的处理方法（默认该方法必须声明在同一个类)
     * 如果不想在同一个类中 blockHandlerClass
     * fallback当接口出现了异常，就可以交给fallback指定的方法进行处理
     *@param id
     *@param ex
     *@return
     * */
    public User blockHandlerForGetUser(String id,BlockException ex){
        ex.printStackTrace();
        return new User("-1","流控!!");
    }

}