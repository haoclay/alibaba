package com.sgq.day9_10.t3;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : SGQ
 * @create 2021/9/10 12:04
 */
public class MyThread implements Runnable {
    private  int apples = 100 ;

    @Override
    public void run(){
        while (apples>0){
            if(apples%2==0){
                synchronized (this){
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
                    f2();

            }

        }

    }
   public synchronized void f1(){

            if(apples>0){
                System.out.println(Thread.currentThread().getName()+"正在卖第"+(apples--)+"个苹果");
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


   }

    public  void f2(){
          synchronized (this){
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
