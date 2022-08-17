package com.sgq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : SGQ
 * @date : 2022-06-13 19:38
 **/
@Controller
public class RouterController {


    @RequestMapping({"/goods/{pageName}"})
    public String goods(@PathVariable("pageName") String pageName){
        return "views/goods/"+pageName;
    }
    @RequestMapping({"/user/{pageName}"})
    public String user(@PathVariable("pageName") String pageName){
        return "views/user/"+pageName;
    }
    @RequestMapping({"/integration/{pageName}"})
    public String integration(@PathVariable("pageName") String pageName){
        return "views/integration/"+pageName;
    }
}