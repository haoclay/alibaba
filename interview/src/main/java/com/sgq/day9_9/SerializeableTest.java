package com.sgq.day9_9;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : SGQ
 * @create 2021/9/9 11:53
 */
public class SerializeableTest {

    static String path= "D:\\aa\\cc\\FF\\animal.txt";


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        f1();
        f2();

    }

    public static  void f1() throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));

        for (int i = 0; i < 10; i++) {
            Animal dog = new Animal();
            dog.setAge(i);
            dog.setName("stive"+i);
            oos.writeObject(dog);

        }
        oos.writeObject(null);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Animal d;
        while ((d = (Animal) ois.readObject())!=null){
            System.out.println(d.toString());
        }
        ois.close();
    }

    public static  void f2() throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));

        List<Animal> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Animal dog = new Animal();
            dog.setAge(i);
            dog.setName("stive"+i);
            list.add(dog);
        }
        oos.writeObject(list);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        List<Animal> result = (ArrayList)ois.readObject();
        Iterator it = result.iterator();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
}
