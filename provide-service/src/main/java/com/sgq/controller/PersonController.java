package com.sgq.controller;

import com.sgq.dao.PersonMapper;
import com.sgq.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    private PersonMapper personMapper;

    @GetMapping("/findAllPerson")
    @ResponseBody
    public List<Person> findAllPerson(){
        System.out.println("查询一次");
        return personMapper.selectAll();
    }

}
