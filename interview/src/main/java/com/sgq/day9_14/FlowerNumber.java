package com.sgq.day9_14;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : SGQ
 * @create 2021/9/16 16:43
 */
public class FlowerNumber {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            int a = i/100;
            int b = i/10%10;
            int c = i%100%10;
            if( i == (a*a*a+b*b*b+c*c*c )){
                System.out.println(i);
            }
        }

    }
}
