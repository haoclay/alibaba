package com.sgq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sgq.pojo.Student;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {

     List<Student> selectByLike();

 }
