package com.sgq.service;

import com.sgq.api.IEmployeeService;
import com.sgq.api.SecondService;
import com.sgq.pojo.Employee;
import org.apache.dubbo.config.annotation.Reference;


import java.util.List;

@org.apache.dubbo.config.annotation.Service
public class SecondServiceImpl implements SecondService {

    @Reference
    private IEmployeeService employeeService;

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeService.findById(id);
    }

    @Override
    public List<Employee> findEmployeeByLike(String name) {
        return employeeService.findByLike(name);
    }

    @Override
    public List<Employee> findByManyProperties(String name, String email) {
        return employeeService.findByManyProperties(name,email);
    }
}
