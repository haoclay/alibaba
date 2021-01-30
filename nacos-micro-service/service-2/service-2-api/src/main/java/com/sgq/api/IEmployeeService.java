package com.sgq.api;

import com.sgq.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IEmployeeService {

     Employee findById(@Param("id") Integer id);

     List<Employee> findByLike(@Param("name") String name);

     List<Employee> findByManyProperties(@Param("name")String name,
                                         @Param("email") String email);
}
