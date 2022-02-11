package com.sgq.day9_10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : SGQ
 * @create 2021/9/10 18:48
 */
public class HashSetTest {
    public static void main(String[] args) {
        Person p1 = new Person("A",11);
        Person p2 = new Person("A",11);
        System.out.println(p1.equals(p2));
        Set hashSet = new HashSet();
        hashSet.add(p1);
        hashSet.add(p2);
        hashSet.add(p1);
        Iterator it = hashSet.iterator();
        while (it.hasNext()){
            Person person = (Person)it.next();
            System.out.println(person);
        }
    }
}
class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
