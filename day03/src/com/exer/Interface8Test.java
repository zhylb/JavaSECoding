package com.exer;

/**
 * 非常不建议实际开发用这么多重名的
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/20 17:29
 */
public class Interface8Test extends Qiangdu implements Kq,Hutao{

    public void chouka(){
        Kq.super.chouka();
        Hutao.super.chouka();
        super.chouka();
        System.out.println("那就胡桃吧 !");
    }


    public static void main(String[] args) {
        Interface8Test interface8Test = new Interface8Test();
        interface8Test.chouka();
    }
}




class Qiangdu{
    public void chouka(){
        System.out.println("选强度高的呀, 当然是胡桃");
    }
}

interface Kq{
    default void chouka(){
        System.out.println("旅行者 : 选刻晴");
    }
}

interface Hutao{
    default void chouka(){
        System.out.println("旅行者 : 选胡桃");
    }
}