package com.sgq.controller;

import com.sgq.api.IStudentService;
import com.sgq.pojo.Student;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Reference
    private IStudentService service;

    @PostMapping("/student/findByMap")
    @ResponseBody
    public List<Student> findByMap(@RequestBody Student student){
        return service.findByMap(student);
    }
}
