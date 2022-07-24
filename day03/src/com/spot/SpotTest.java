package com.spot;

/**
 * Part9中也有 更为感性的演示
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/1/29 10:42
 */
public class SpotTest {
    //在局部内部类中的方法中，如果要调用外部方法中的属性对象，要求此对象为final
    //在jdk7 中 要求显示声明为 final
    //在jdk8 中 不要求显示声明为 final
    //
    //int a = 10
    public void show(){
        int a = 5;
        // a += 1; //这一行打开后 class A 方法中的 me()会报错
        // Variable 'a' is accessed from within inner class, needs to be final or effectively final
        System.out.println();
        class A{
            public void me(){
                System.out.println(a);
            }
        }
    }


    public static void main(String[] args) {





    }
}
