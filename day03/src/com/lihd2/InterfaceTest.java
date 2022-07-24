package com.lihd2;

/**
 * 接口 : 定义了一种规范 使用interface定义
 * 接口和类 是并列的结构
 *
 *
 *      JDK7 及之前 接口的定义 只能定义 全局常量与抽象方法
 *          1 全局常量 : public static final , 可以省略 public static final
 *          2 抽象方法 : public abstract     , 可以省略 public abstract
 *      JDK8 及之后 接口的定义
 *
 * 接口中不能定义构造器 因此接口不能实例化
 *
 * 接口一般需要类去实现
 *      如果实现了所有的接口方法, 那么这个类可以实例化
 *      如果没有实现所有的接口方法, 那么这个类需要是抽象类
 *
 * 一个类可以实现多个接口 -> 打破了java的单继承性
 *      格式 class AA extends BB implements CC, DD,EE...
 *
 *      public final class String
 *     implements java.io.Serializable, Comparable<String>, CharSequence {
 *
 * 接口之间是是继承关系, 而且可以多继承
 *      interface AA extends BB,CC,...
 *
 * *******************************
 * 接口的使用 : 体现多态性
 * 接口 更多是has a的关系
 *
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/20 12:47
 */
public class InterfaceTest {

    public static void main(String[] args) {
        Bird b = new Bird();
        b.fly();
        b.stop();
    }
}

interface Flyable{
    public static final int MAX_SPEED = 7900;

    //可以省略前面的 public static final
    int MIN_SPEED = 1;

    public abstract void fly();
    //可以省略前面的 public abstract
    void stop();
}

class Bird implements Flyable{

    @Override
    public void fly() {
        System.out.println("Bird::fly");
    }

    @Override
    public void stop() {
        System.out.println("Bird::stop");
    }
}

interface AA{
    void a();
}

interface BB{
    void b();
}

interface CC extends AA, BB{

}


class C extends Object implements CC{

    @Override
    public void a() {

    }

    @Override
    public void b() {

    }
}

//不实现接口中的方法, 这个类需要是抽象类
abstract class D implements AA{

}