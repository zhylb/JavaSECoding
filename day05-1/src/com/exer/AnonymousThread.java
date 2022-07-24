package com.exer;

/**
 * 方法1 匿名类匿名对象
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/6 10:08
 */
public class AnonymousThread {

    public static void main(String[] args) {

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            }
        }.start();


        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            }
        }.start();

    }

}
