package com.java09.lihd;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/19 9:58
 */
public class MyInterfaceTest {
    public static void main(String[] args) {
        MyInterfaceImpl impl = new MyInterfaceImpl();
        impl.show();//实现类调用抽象方法
        impl.showDefault();//实现类调用默认方法
        MyInterface.methodStatic();//接口中的静态方法属于接口

        //接口中的常量既可以接口调用，也可以类调用
        System.out.println(MyInterface.a);
        System.out.println(MyInterfaceImpl.a);


    }
}
class MyInterfaceImpl implements MyInterface{

    @Override
    public void show() {
        System.out.println("我重写接口中的抽象方法");
    }


}