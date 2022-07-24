package com.lihd2;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/17 10:25
 */
public class Student extends Person{
    int id = 2002;


    @Override
    public void walk() {
        System.out.println("Student::walk");
    }


    public void show(){
        System.out.println("this.name : " + this.name);
        System.out.println("super.name : " + super.name);
        System.out.println("name : " + name);

        System.out.println("this.id : " + this.id);
        System.out.println("super.id : " + super.id);
        System.out.println("id : " + id);
    }

    public void showMethod(){
        System.out.println("-------------------");
        this.walk();
        super.walk();
        walk();
        System.out.println("-------------------");
        this.say();
        super.say();
        say();

    }



}
