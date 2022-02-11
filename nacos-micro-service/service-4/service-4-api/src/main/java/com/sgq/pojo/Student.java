package com.sgq.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("student")
public class Student implements Serializable {
    @TableId("id")
    private Integer id;

    @TableField("clazz")
    private  String clazz;

    @TableField("name")
    private  String name;

    @TableField("phone")
    private  String phone;

    @TableField("state")
    private  String state;
}
