package com.lihd3;

import java.util.Random;

/**
 * 证明多态是运行时行为
 *
 * 多态与重写重载
 *
 * 重载，是指允许存在多个同名方法，而这些方法的参数不同。 编译器根据方法不
 * 同的参数表， 对同名方法的名称做修饰。对于编译器而言，这些同名方法就成了
 * 不同的方法。 它们的调用地址在编译期就绑定了。 Java的重载是可以包括父类
 * 和子类的，即子类可以重载父类的同名不同参数的方法。
 * 所以： 对于重载而言，在方法调用之前，编译器就已经确定了所要调用的方法，
 * 这称为“早绑定”或“静态绑定” ；
 * 而对于多态，只有等到方法调用的那一刻， 解释运行器才会确定所要调用的具体
 * 方法，这称为“晚绑定”或“动态绑定” 。
 * 引用一句Bruce Eckel的话： “不要犯傻，如果它不是晚绑定， 它就不是多态。”
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/18 13:04
 */
public class AnimalTest {
    static Random r = new Random();

    public static void main(String[] args) {
        Animal instance = getInstance();
        showing(instance);
    }

    public static void showing(Animal animal){
        animal.show();
    }

    public static Animal getInstance(){
        int a = r.nextInt(3);
        Animal animal;
        switch (a) {
            case 0:
                animal = new Cat();
                break;
            case 1:
                animal = new Dog();
                break;
            case 2:
                animal = new Sheep();
                break;
            default:
                animal = null;
        }
        return animal;

    }

}

class Animal{
    public void show(){
        System.out.println("我不知道我是什么");
    }
}

class Cat extends Animal{
    public void show(){
        System.out.println("妙啊");
    }
}

class Dog extends Animal{
    @Override
    public void show() {
        System.out.println("汪");
    }
}

class Sheep extends Animal{
    public void show(){
        System.out.println("达咩");
    }
}
