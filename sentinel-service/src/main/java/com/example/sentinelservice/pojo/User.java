package com.example.sentinelservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;
    private String name;

    public static User fallBackGetUser(String id){

        return new User("2","被服务降级了");
    }
}