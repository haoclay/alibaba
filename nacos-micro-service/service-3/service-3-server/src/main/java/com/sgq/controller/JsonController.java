package com.sgq.controller;

import com.sgq.pojo.Staff;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class JsonController {

    @RequestMapping("/json/show")
    public Map show(@RequestBody Staff staff){
        System.out.println(staff);
         Map<String, Staff> map = new HashMap(){{
             put("A01",staff);
         }};
         return map;
    }

    @RequestMapping("/jsonPage")
    public ModelAndView jsonPage(){
        ModelAndView mv = new ModelAndView("json/myJson");
        return mv;
    }

}
