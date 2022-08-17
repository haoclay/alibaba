package com.sgq.service;

import com.sgq.pojo.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findByMap(Student student);

}
