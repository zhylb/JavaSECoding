package com.lihd1;

/**
 * abstract使用需要注意的地方
 *
 * abstract 可以修饰类, 修饰方法
 * final 可以修饰类, 修饰方法, 修饰属性
 * static 可以修饰 属性, 方法, 代码块, 内部类
 * private 可以修饰 属性 方法 构造器 内部类
 *
 *
 * 1 abstract 和 final 不能一起修饰类, 修饰方法
 *      因为abstract可以理解为鼓励继承, 需要子类实现重写方法
 *      而final是完全否定了继承与重写, 因此无法共存
 * 2 abstract 和 private 无法一起修饰方法
 *      因为 private 的方法无法被重写
 *      一个无法被重写的方法 不可能被子类重写, 因此两个关键字冲突
 *
 * 3 abstract 和 static 无法一起修饰方法
 *      因为静态方法没有重写一说
 *      而abstract建议冲突, 两个关键字冲突
 *
 *
 * 4 抽象类只是可能含有抽象方法, 除了不能实例化之外, 与其他的类没有什么区别
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/20 9:53
 */
public abstract class AbstractAttention {

    //会报错
//    private abstract void show(){
//
//    }

    //会报错
//    public static abstract void walk(){
//
//    }

    //会报错
//    public final abstract void talk(){
//
//    }

}

//会报错
//abstract final class A{}
