package com.sgq.day9_10.t1;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : SGQ
 * @create 2021/9/10 12:04
 */
public class MyThread extends Thread {
    private String lock ;
    private static int apples = 100 ;

    public MyThread(String name,String lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run(){
        while (apples>0){
            if(apples%2==0){
                synchronized (lock){
                     if(apples>0){
                         System.out.println(Thread.currentThread().getName()+"正在卖第"+(apples--)+"个苹果");
                     }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }else {
                    f1();
            }

        }

    }
   public void f1(){
        synchronized (lock){
            if(apples>0){
                System.out.println(Thread.currentThread().getName()+"正在卖第"+(apples--)+"个苹果");
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

   }

}
