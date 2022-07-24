package com.lihd2;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/17 12:49
 */
public class Son extends Father{

    int level;


    public Son(){
        System.out.println("Son::()");
    }


    public Son(int age, int level){
        super(age);
        System.out.println("Son(int age,int level");
        this.level = level;
    }

    //如果父类中的name为私有属性, 那么给这个值赋值只能通过set或者构造器+super
    public Son(int age,String name, int level){
        super(name, age);
        System.out.println("Son(int age, String name, int level)");
        this.level = level;

    }

    public Son(String name){

    }

    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println("------------------");
        Son s2 = new Son("2");
        System.out.println("------------------");
        Son s3 = new Son(14,89);
        System.out.println("------------------");
    }


}
