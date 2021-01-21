package com.example.alibaba.test.uitls;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Author : sgq
 * Date : 2021/1/21 16:33
 */
public class PasswordTool {
    public static void main(String[] args) {

        System.out.println(new BCryptPasswordEncoder().encode("haoclay"));
    }
}
