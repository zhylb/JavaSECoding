package com.lihd3;

/**
 * Java8 及以后 可以有默认方法 静态方法 越来越像一个类
 *
 * 静态方法
 *      public static 可以省略 public
 *      1 静态方法只能够接口调用, 实现接口的对象无法调用
 *      2
 *
 * 默认方法
 *      public default 可以省略 public
 *      1 如果一个类实现两个接口 , 该接口中有相同的默认方法
 *          解决方案1 : 继承的父类中也有此方法, 且是public的 类优先原则
 *          解决方案2 : 重写这个方法
 *      2 如果一个类实现两个接口, 并继承了一个类, 他们有一个相同的默认方法或方法
 *          调用父类的方法 : super.method()
 *          调用接口的方法 : Interface.super.method()
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/20 17:13
 */
public class Interface8Test extends Base implements MyInterface,MethodA,MethodB{

    //1 method1()到底用不用重写
    //如果父类中的method1() 是public : 不用重写
    //如果父类中的method1() 不是public : 需要重写




    //由于 父类中没有method2()
    //因此有接口冲突, 必须要重写
    @Override
    public void method2() {

    }

    public static void main(String[] args) {
        Interface8Test t = new Interface8Test();
        t.showThis();
    }

    @Override
    public String toString() {
        return "toString :: 方法";
    }
}

interface MyInterface{

    static void staticMethod(){
        System.out.println("MyInterface::static");
    }

    default void showThis(){
        System.out.println(this);
    }


    default void method1(){
        System.out.println("MyInterface::method1");
    }

    default void method2(){
        System.out.println("MyInterface::method2");
    }

    default void method3(){
        System.out.println("MyInterface::method3");
    }
}

class Base{
    public void method1(){
        System.out.println("Base::method1");
    }
}

interface MethodA{
    default void method1(){
        System.out.println("MethodA::method1");
    }

    default void method2(){
        System.out.println("MethodA::method2");
    }
}

interface MethodB{
    default void method1(){
        System.out.println("MethodB::method1");
    }

    default void method2(){
        System.out.println("MethodB::method2");
    }
}