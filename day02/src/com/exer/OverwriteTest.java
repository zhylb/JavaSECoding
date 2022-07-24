package com.exer;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/18 15:04
 */
public class OverwriteTest {
    public static void main(String[] args) {
        Base b = new Sub();
        b.add(1,2,3);

        Sub s = (Sub) b;
        s.add(1,2,3);
    }
}

class Base{
    public void add(int a, int...arr){
        System.out.println("Base");
    }
}

class Sub extends Base{
    //这里是重写, 因为这个方法无法和上一个方法共存,不是重载
    public void add(int a, int[] arr){
        System.out.println("Sub::1");
    }

    public void add(int a, int b, int c){
        System.out.println("Sub::2");
    }
}