package com.sgq.controller;



import com.sgq.api.FirstService;
import com.sgq.api.SecondService;
import com.sgq.pojo.Employee;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicationController {
    @Reference
    private FirstService firstService;
    @Reference
    private SecondService secondService;

    @RequestMapping(value = "/doService")
    public String doService(){
        String str = firstService.doFirst();
        return "application-1 |"+str;
    }

    @RequestMapping(value = "/findOneEmployee")
    public Employee doServiceWithDataSource(@RequestParam Integer id){
        Employee employee = secondService.findEmployeeById(id);
        return employee;
    }

    @RequestMapping(value = "/findEmployeeByName")
    public List<Employee> findEmployeeByName(@RequestParam String name){
        return  secondService.findEmployeeByLike(name);
    }
}
