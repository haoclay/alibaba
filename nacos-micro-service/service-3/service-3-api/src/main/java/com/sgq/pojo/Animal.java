package com.sgq.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("animal")
public class Animal implements Serializable {
    @TableId("id")
    private Integer id ;
    @TableField("name")
    private  String name;
    @TableField("age")
    private  Integer age;
}
