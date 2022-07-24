package com.lihd1;

/**
 * abstract : 抽象的
 *
 * abstract : 可以修饰 类 修饰 方法
 *
 * 1 abstract 修饰类
 *      1 该类无法实例化
 *      2 该类中还是有构造器, 供子类使用
 *      3 前提 : 有继承关系
 *      4 开发中 抽象类一般会提供可以使用的子类,让子类对象实例化, 以便完成相关的功能
 *
 * 2 abstract 修饰方法
 *      1 该方法无法被子类重写 只有方法的声明, 没有方法体
 *      2 含有抽象方法的类一定是抽象类
 *      3 抽象类可以没有抽象方法
 *      4 如果子类重写了所有的抽象方法 方可实例化
 *      5 如果子类没有重写所有的方法, 这个类也是抽象类
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/20 9:42
 */
public class AbstractTest {

    public static void main(String[] args) {
        //多态
        Person p = new Student();


        p.talk();
        p.breath();
    }

}
abstract class Creature{
    //抽象方法的定义格式 没有方法体, 用分号结束
    public abstract void breath();
}

// person 没有重写父类的抽象方法, 因此也是抽象类
abstract class Person extends Creature{

    String name;
    int age;
    //下面的构造器 为子类提供
    Person(){}

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    //再定义一个抽象方法
    public abstract void talk();

}

//重写父类中的所有抽象方法 方可以实例化
class Student extends Person{

    @Override
    public void breath() {
        System.out.println("感觉空气不如...美国");
    }

    @Override
    public void talk() {
        System.out.println("外国的月亮比较圆");
    }
}