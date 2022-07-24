package com.lihd;

import java.io.IOException;

/**
 * 子类抛出的异常不能大于父类 子类可以不抛出异常
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/5 20:30
 */
public class OverrideTest {
}

class A{

    public void show()throws IOException {
        System.out.println("A::show");
    }
}

class B extends A{
//    @Override
//    public void show() throws Exception {//由于抛出异常大于父类，报错
//        System.out.println("B::show");
//    }

    @Override
    public void show(){
        System.out.println("B::show");
    }
}
