package com.sgq.day9_10;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : SGQ
 * @create 2021/9/10 11:18
 */
public class ThreadTest extends Thread {
    public int ThreadNo = 0 ;

    public ThreadTest(int threadNo) {
        this.ThreadNo = threadNo;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new ThreadTest(i).start();
            Thread.sleep(1);
        }
    }
    @Override public synchronized void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("No."+ThreadNo+":"+i);
        }

    }
}
