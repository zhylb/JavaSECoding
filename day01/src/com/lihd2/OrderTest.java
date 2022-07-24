package com.lihd2;

/**
 *
 * 探究对象赋值的顺序
 *
 * 默认初始化 -> 显式初始化 -> 构造器初始化 -> 对象.setXxx
 *
 * 在构造器中调用了方法
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/9 21:30
 */
public class OrderTest {

    int a = 1;

    public OrderTest(int a) {
        showA();// 结果必定为 1
        this.a = a;
        showA();// 结果为 a
    }

    public void showA(){
        System.out.println(a);
    }

    public static void main(String[] args) {
        OrderTest o = new OrderTest(10);

        o.a = 100;
        //打印结果 1 10 100
        System.out.println(o.a);

    }
}
