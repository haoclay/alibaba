package com.sgq.day9_10.t1;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : SGQ
 * @create 2021/9/10 12:06
 */
public class Main {
    public static void main(String[] args) {
        Thread t1 = new MyThread("t11","LOCK");
        Thread t2 = new MyThread("t22","LOCK");

        t1.start();
        t2.start();

    }
}
