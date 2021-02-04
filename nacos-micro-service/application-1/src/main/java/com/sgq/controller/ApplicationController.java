package com.sgq.controller;



import com.sgq.api.FirstService;
import com.sgq.api.SecondService;
import com.sgq.api.ThirdService;
import com.sgq.pojo.Animal;
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
    @Reference
    private ThirdService thirdService;

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

    @RequestMapping(value = "/findEmployeeByNameAndEmail")
    public List<Employee> findEmployeeByNameAndEmail(@RequestParam String name,
                                                     @RequestParam String email){
        return  secondService.findByManyProperties(name,email);
    }

    @RequestMapping(value = "/findAllAnimal")
    public List<Animal> findAllAnimal(){
        return  thirdService.findAll();
    }

    @RequestMapping(value = "/findAnimalByLike")
    public List<Animal> findAnimalByLike(@RequestParam String name,@RequestParam Integer age){
        return  thirdService.findByLike(name,age);
    }

    @RequestMapping(value = "/findAnimalByDefault")
    public List<Animal> findAnimalByDefault(@RequestParam String name,@RequestParam Integer age){
        return  thirdService.findByLikeDefault(name,age);
    }

}
