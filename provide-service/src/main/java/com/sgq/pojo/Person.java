package com.sgq.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "person")
public class Person {
    @TableId(value = "id")
    private Integer id ;
    @TableField(value = "name")
    private String name;
}
