package com.sgq.controller;



import com.sgq.api.FirstService;
import com.sgq.api.FourthService;
import com.sgq.api.SecondService;
import com.sgq.api.ThirdService;
import com.sgq.pojo.Animal;
import com.sgq.pojo.Employee;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApplicationController {
    @Reference
    private FirstService firstService;
    @Reference
    private SecondService secondService;
    @Reference
    private ThirdService thirdService;
    @Reference
    private FourthService fourthService;

    @RequestMapping(value = "/doService")
    public String doService(){
        String str = firstService.doFirst();
        return "application-1 |"+str;
    }

    @RequestMapping(value = "/findOneEmployee")
    public Employee doServiceWithDataSource(@RequestParam Integer id, HttpServletResponse response){
        Employee employee = secondService.findEmployeeById(id);
        System.out.println(employee);
        response.setCharacterEncoding("utf-8");
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

    @RequestMapping(value = "/sendEmailByQQ")
    public void sendEmailByQQ(@RequestParam String mail_target,
                              @RequestParam String mail_title,
                              @RequestParam String mail_content ){
        Map<String,String> map = new HashMap(){{
            put("mail_target",mail_target);
            put("mail_title",mail_title);
            put("mail_content",mail_content);
        }};
        fourthService.sendEmailByQQ(map);
    }

}
