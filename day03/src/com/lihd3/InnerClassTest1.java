package com.lihd3;

/**
 * 局部内部类的使用
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/21 16:25
 */
public class InnerClassTest1 {

    //很少使用
    public void show(){
        class A{}
    }

    //较为常见
    public Comparable getComparable(){
        class A implements Comparable{

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }

        return new A();
    }

    //更为简单的形式 匿名的局部内部类对象被返回
    public Comparable getCom(){
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
}
