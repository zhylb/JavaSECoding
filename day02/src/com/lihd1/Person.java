package com.lihd1;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/17 8:56
 */
public class Person {
    String name;
    int age;

    public void eat(){
        System.out.println("Person::eat");
    }

    public void walk(){
        System.out.println("Person::walk");
    }

    private void say(){
        System.out.println("Person::private say");
    }

    public void showAll(){
        this.eat();
        this.walk();
        this.say();
        methodStatic();
    }

    public static void methodStatic(){
        System.out.println("父类中的静态方法");
    }

    public Object method1(){
        return null;
    }

    public void method2() throws Exception{
        throw new Exception("抛个异常");
    }
}
