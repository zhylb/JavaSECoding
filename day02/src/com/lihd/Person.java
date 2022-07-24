package com.lihd;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/10 11:26
 */
public class Person extends Creature{
    private int numPrivate = 7;
    int age;
    String name;

    public void show(){
        System.out.println("age = " + age);
        System.out.println("name = " + name);
        showPrivate();
        System.out.println(this);
    }

    private void showPrivate(){
        System.out.println("numPrivate = " + numPrivate);
    }

    @Override
    public String toString() {
        return "Person{" +
                "numPrivate=" + numPrivate +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
