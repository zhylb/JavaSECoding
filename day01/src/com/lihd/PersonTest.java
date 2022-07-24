package com.lihd;

/**
 * 面向对象思想的体现
 * 1 创建类, 设计类的成员
 * 2 创建对象
 * 3 使用对象, 解决问题
 *
 *
 * 其中最复杂 最费时的是类的设计 而使用对象一般也需要一点的学习成本
 * 而一个语言是否强大很大程度上看类库的设计 类是否丰富
 *
 * 对象的创建类似于 : 根据汽车图纸制造汽车
 * 而如果想要根据一辆车反推回原来的图纸 : 反射 以后会学到
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/8 16:52
 */
public class PersonTest {
    public static void main(String[] args) {
        //多个对象的关系
        Person p1 = new Person();
        p1.age = 36;
        Person p2 = new Person();
        //因为p2 和 p1 没有关系 因此p2的值是 默认值18
        System.out.println(p2.age);//18

        Person p3 = p1;
        p3.name = "hello";
        //因为 p3和p1 指向内存中的同一对象, 因此p3的改变会影响p1的改变
        System.out.println(p1.name);//hello


    }
}
//第一步 : 创建类的对象
class Person{
    // 1 属性 field
    int age = 18;
    String name;
    boolean isMale;


    // 2 方法 method
    public void talk(){
        System.out.println("中国人不骗中国人");
    }

    public void show(String lan){
        System.out.println("我喜欢说 : " + lan);
    }


}
