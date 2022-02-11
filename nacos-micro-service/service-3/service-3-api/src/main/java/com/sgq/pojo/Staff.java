package com.sgq.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class Staff {
    private int id ;
    private String name;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    public Staff(){

    }
    public Staff(int id, String name, Date createDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
    }


}
