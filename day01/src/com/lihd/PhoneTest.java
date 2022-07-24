package com.lihd;

/**
 * 如何理解万事万物皆对象
 *
 *
 *
 * 匿名对象:
 *  1 匿名对象没有显示的变量名
 *  2 匿名对象只能调用一次 存放于堆空间中
 *  3 匿名对象可以作为参数传入方法或构造器 变相的获取了 自己的姓名
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/9 9:16
 */
public class PhoneTest {
    public static void main(String[] args) {

        //使用匿名对象
        new Phone().call();
        new Phone().playGame();

        //修改匿名对象的属性 是没有意义的
        new Phone().name = "iPhone";
        System.out.println(new Phone().name);//null

        //将匿名对象作为参数传入方法(构造器) 重新赋予了这个对象的名称
        PhoneMall mall = new PhoneMall();
        mall.show(new Phone());

        //匿名对象传入匿名对象
        new PhoneMall().show(new Phone());


    }
}

class PhoneMall{
    public void show(Phone p){
        p.playGame();
        p.call();
    }
}

class Phone{
    String name;
    double price;

    public void playGame(){
        System.out.println("可以打游戏");
    }

    public void call(){
        System.out.println("可以打电话");
    }
}
