package com.java09.lihd;

/**
 * 接口中可以定义私有方法 since1.9
 * 接口越来越像一个类，这玩意和抽象类还能差多少呢？
 */
public interface MyInterface {

    int a = 5;
    //抽象方法
    void show();
    //
    static void methodStatic(){
        System.out.println("我是接口中的静态方法");
    }
    //默认方法
    default void showDefault(){
        System.out.println("我是接口中的默认方法，可以、被重写");
        methodPrivate();//私有方法仅提供接口调用
    }

    //java9 新增 私有方法
    private void methodPrivate(){
        System.out.println("我是私有方法，只能是接口来调用");
    }


}
