package com.sgq.controller;

import com.sgq.api.IEmployeeService;
import com.sgq.pojo.Employee;
import com.sgq.service.EmployeeServiceImpl;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Reference
    private IEmployeeService employeeService;

    @GetMapping("/findById")
    public Employee findById(@RequestParam Integer id){
       return employeeService.findById(id);
    }
}
