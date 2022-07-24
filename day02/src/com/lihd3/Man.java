package com.lihd3;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/18 11:42
 */
public class Man extends Person{
    boolean isCoding;
    int id = 1002;

    @Override
    public void talk() {
        System.out.println("Man::talk");
    }

    @Override
    public void walk() {

        System.out.println("Man::walk");
    }

    public void earnMoney(){
        System.out.println("Man::earnMoney");
    }

    //重载而不是重写
    public void method(int a){
        System.out.println(2);
    }
}
