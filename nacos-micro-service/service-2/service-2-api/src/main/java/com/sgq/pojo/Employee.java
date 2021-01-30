package com.sgq.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "employee")
public class Employee implements Serializable {
    @TableId(value = "id")
    private Integer id;
    @TableField(value = "last_name")
    private String lastName;
    @TableField(value = "email")
    private String email;
    @TableField(value = "gender")
    private String gender;
    @TableField(value = "age")
    private Integer age;
    @TableField(value = "department_id")
    private Integer departmentId;

}
