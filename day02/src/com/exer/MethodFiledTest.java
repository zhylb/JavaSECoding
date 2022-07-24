package com.exer;


class A{
    int num = 1;

    public void show(){
        System.out.println(num);
    }
}

class B extends A{
    int num = 2;

    public void show(){
        System.out.println(num);
    }
}

class C extends B{
    int num = 3;

    public void show(){
        System.out.println(num);
    }
}

/**
 * 结论 方法可以被覆盖 属性不会被覆盖
 *
 *
 *
 *
 */
public class MethodFiledTest {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.num);//3
        c.show();//3

        B b = c;
        System.out.println(c ==  b);//true
        System.out.println(b.num);//2
        b.show();//3

        A a = b;
        System.out.println(a == b);//true
        System.out.println(a.num);//1
        a.show();//3
    }

}

