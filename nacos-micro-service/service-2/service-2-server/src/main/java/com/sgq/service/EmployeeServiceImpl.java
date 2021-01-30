package com.sgq.service;

import com.sgq.api.IEmployeeService;
import com.sgq.dao.EmployeeMapper;
import com.sgq.pojo.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@org.apache.dubbo.config.annotation.Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;


    public Employee findById(@Param("id") Integer id) {
        return employeeMapper.selectById(id);
    }


    public List<Employee> findByLike(@Param("name")String name) {
        return employeeMapper.selectByLike(name);
    }


}
