package com.sgq.day9_10.t3;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : SGQ
 * @create 2021/9/10 12:06
 */
public class Main {
    public static void main(String[] args) {
        MyThread task =  new MyThread();
       Thread t1 = new Thread(task,"t11");
       Thread t2 = new Thread(task,"t22");
        t1.start();
        t2.start();

    }
}
