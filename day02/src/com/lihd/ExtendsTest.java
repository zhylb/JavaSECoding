package com.lihd;

/**
 * 继承 extends 延展 拓展
 * 继承的好处
 *      1 减少代码冗余, 提高代码的复用性
 *      2 便于功能拓展
 *      3 为多态提供了前提
 *
 * 继承的格式 : A extends B
 *      A 子类, 派生类, subclass
 *      B 父类, 超类, 基类, superclass
 *
 *
 * 继承的特点 :
 *      1 子类A 继承父类B后, 将获取父类中的所有属性和方法
 *      2 父类中的私有方法, 私有属性,子类无法直接访问, 但是子类中仍存在
 *      3 子类继承父类后, 可以对功能进行拓展, 因此子类的功能一般更丰富
 *
 * java中继承的特点 :
 *      1 一个类可以被多个子类继承
 *      2 Java类具有单继承性 : 一个类只能有一个父类
 *      3 支持多层继承, 子类父类是相对的概念
 *      4 直接继承的父类称为直接父类, 间接继承的类称为间接父类
 *      5 子类可以获取父类和间接父类中所有的属性和方法
 *
 *
 * Object 类的理解 :
 *      1 如果一个类没有显示声明父类 那么其继承于java.lang.Object
 *      2 所有的类(除自身)都直接继承或间接继承与 java.lang.Object类
 *      3 因此所有的类都具有Object类中的方法
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/10 11:26
 */
public class ExtendsTest {
    public static void main(String[] args) {
        Student s = new Student();
        s.show();// 其中有numPrivate 只不过 无法直接访问
        // person类中的show()方法 中含有 sout(this) 而 子类调用时 打印的是子类的信息 Student{id=1002, age=0, name='null'}
        // 因此子类可以获取父类中的所有的方法和属性
        s.breath();
    }
}
