package com.sgq.day9_4;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : SGQ
 * @create 2021/9/4 17:39
 */
public class Test02 {


    public static void main(String[] args) {
        MyInstance instance = MyInstance.getInstance();
        System.out.println("a:"+instance.a);
        System.out.println("b:"+instance.b);
    }
}
class MyInstance{
    public static int a = 1;

    private static MyInstance instance = new MyInstance();
    public MyInstance (){
        a++;
        b++;
    }
    public static int b = 1;

    public static MyInstance getInstance(){
        return instance;
    }



        }
