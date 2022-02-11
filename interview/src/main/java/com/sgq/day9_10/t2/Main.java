package com.sgq.day9_10.t2;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : SGQ
 * @create 2021/9/10 12:06
 */
public class Main {
    public static void main(String[] args) {
       Thread t1 = new Thread(new MyThread("l1"),"t11");
       Thread t2 = new Thread(new MyThread("l2"),"t22");
        t1.start();
        t2.start();

    }
}
