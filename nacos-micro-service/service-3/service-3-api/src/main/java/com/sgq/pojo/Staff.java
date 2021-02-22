package com.sgq.pojo;

import lombok.Data;

import java.util.Date;


@Data
public class Staff {
    int id ;
    String name;
    Date createDate;
    public Staff(){

    }
    public Staff(int id, String name, Date createDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
    }
}
