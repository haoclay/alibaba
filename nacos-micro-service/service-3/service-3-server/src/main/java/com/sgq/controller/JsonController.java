package com.sgq.controller;

import com.alibaba.fastjson.JSONObject;
import com.sgq.pojo.Staff;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
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

    @RequestMapping("/json/display")
    public Map display(@RequestBody Staff staff){
        System.out.println(staff);
        Map<String, Staff> map = new HashMap(){{
            put("A01",staff);
        }};
        return map;
    }

    @RequestMapping("/json/getData")
    public Map getData(@RequestParam("id") Integer id,
                       @RequestParam("name") String name){
        System.out.println(id+ "===" +name);
        Map<String, Staff> map = new HashMap(){{
            put("A01","staff");
        }};
        return map;
    }

    @RequestMapping("/json/getListData")
    public Map getListData(@RequestBody List<Staff> staffList){
        System.out.println(staffList);
        Map<String, Staff> map = new HashMap(){{
            put("staffs",staffList);
        }};
        return map;
    }
    @RequestMapping( value = {"/json/getFormData"},method = RequestMethod.POST)
    public Map getFromData(@RequestBody Staff staff){
        /*Staff object = JSONObject.parseObject(staff, Staff.class);
        System.out.println(object);*/
        Map<String, Staff> map = new HashMap(){{
            put("staff",staff);
        }};
        return map;
    }

    @RequestMapping("/jsonPage")
    public ModelAndView jsonPage(){
        ModelAndView mv = new ModelAndView("json/myJson");
        return mv;
    }

}
