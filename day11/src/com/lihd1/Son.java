package com.lihd1;

import java.lang.annotation.Repeatable;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/17 15:32
 */
@MyAnnotation
public class Son extends Father<String > implements Comparable<Integer>,MyInterface<String ,Integer,Object>{

    private int age;
    int id;
    protected String school;
    public String name;

    private static int staticNum = 5;
    @MyAnnotation("ConsPublic")
    public Son() {
    }

    public Son(int age, int id, String school, String name) {
        this.age = age;
        this.id = id;
        this.school = school;
        this.name = name;
    }

    Son(int age){
        this.age = age;
    }

    protected Son(int age,int id){
        this.age = age;
        this.id = id;
    }
    @MyAnnotation("Cons")
    private Son(String name){
        this.name = name;
    }

    public static void  show(String a){
        System.out.println("Son::show() - " + a);
    }

    public  void sonPublic(@MyAnnotation String s){
        System.out.println(s);
    }

    public static synchronized void staticMethod(int a,int b,int c) throws RuntimeException{

    }

    private  String sonPrivate(@MyAnnotation int a){
        return this.name + " : a";
    }

    @Override
    @MyAnnotation
    public void inter() {
        System.out.println("Son重写了inter()");
    }

    @Override
    public int compareTo(Integer o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Son{" +
                "age=" + age +
                ", id=" + id +
                ", school='" + school + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
