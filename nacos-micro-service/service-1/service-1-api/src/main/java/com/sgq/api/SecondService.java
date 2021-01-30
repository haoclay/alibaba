package com.sgq.api;

import com.sgq.pojo.Employee;

import java.util.List;

public interface SecondService {

     Employee findEmployeeById(Integer id);

     List<Employee>  findEmployeeByLike(String name);
}
