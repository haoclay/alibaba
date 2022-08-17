package com.sgq.service;

import com.sgq.mapper.StudentMapper;
import com.sgq.pojo.Student;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper mapper;

    public List<Student> findByMap(Student student){
        Map<String, Object> map = new HashMap();
        String name = student.getName();
        String clazz = student.getClazz();
        String phone = student.getPhone();
        String state = student.getState();
        if(name!=null && name!=""){
            map.put("name",name);
        }
        if(clazz!=null && clazz!=""){
            map.put("clazz",clazz);
        }
        if(phone!=null && phone!=""){
            map.put("phone",phone);
        }
        if(state!=null && state!=""){
            map.put("state",state);
        }

       return mapper.selectByMap(map);
    }


}
