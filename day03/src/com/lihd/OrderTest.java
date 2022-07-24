package com.lihd;

/**
 * 对象属性的赋值顺序
 *
 * 1 默认初始化
 * 2 显式初始化 / 代码块 (谁在上谁先执行)
 * 3 构造器
 * 4 对象.属性 或 对象.方法
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/19 23:53
 */
public class OrderTest {
    public static void main(String[] args) {

        //谁在上谁先执行
        System.out.println(new Order1().a);//4
        System.out.println(new Order2().a);//20
    }
}

class Order1{
    int a = 3;
    {
        a = 4;
    }
}

class Order2{
    {
        a = 10;
    }
    int a = 20;
}
