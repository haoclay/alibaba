package com.sgq.day9_4;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : SGQ
 * @create 2021/9/4 10:44
 */
public class Test01 {

    public static void main(String[] args) {
        String str1 = "通话";String str2 = "重地";
        System. out. println(String. format("str1：%d | str2：%d",  str1. hashCode(),str2. hashCode()));
        System. out. println(str1. equals(str2));
    }
}
