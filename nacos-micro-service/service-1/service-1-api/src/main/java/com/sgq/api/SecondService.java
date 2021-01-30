package com.sgq.api;

import com.sgq.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SecondService {

     Employee findEmployeeById(Integer id);

     List<Employee>  findEmployeeByLike(String name);

     List<Employee>   findByManyProperties(@Param("name")String name,
                          @Param("email") String email);
}
