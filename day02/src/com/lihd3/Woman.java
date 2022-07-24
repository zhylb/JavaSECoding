package com.lihd3;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/18 11:42
 */
public class Woman extends Person{
    boolean isBeautiful;
    int id = 1003;

    @Override
    public void talk() {
        System.out.println("Woman::talk");
    }

    @Override
    public void walk() {
        System.out.println("Woman::walk");
    }

    public void spendMoney(){
        System.out.println("Woman::spendMoney");
    }

    //重载 而不是重写
    public void method(int a){
        System.out.println(2);
    }
}
