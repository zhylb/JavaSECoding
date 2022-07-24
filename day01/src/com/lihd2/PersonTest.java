package com.lihd2;

/**
 * 构造器（或构造方法）：Constructor
 *
 * 构造器的作用：
 *    1.创建对象
 *    2.初始化对象的信息
 *
 * 构造器的使用:
 *       1.如果没显式的定义类的构造器的话，则系统默认提供一个空参的构造器
 *       2.定义构造器的格式：权限修饰符  类名(形参列表){}
 *       3.一个类中定义的多个构造器，彼此构成重载
 *       4.一旦我们显式的定义了类的构造器之后，系统就不再提供默认的空参构造器
 *       5.一个类中，至少会有一个构造器。
 *       6.默认构造器的权限与类的权限相同
 *
 * 建议 : 如果没有特殊必要, 在有其他构造器时 显示提供空参构造器
 *
 *
 *
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/9 19:59
 */
public class PersonTest {

    public static void main(String[] args) {
        Person p = new Person();

        Person pp = new Person(14,"Tom");
    }
}

class Person{
    private int age;
    private String name;

    public Person(){
        System.out.println("Person::()");
    }

    public Person(int age,String name){
        this.age = age;
        this.name = name;

        System.out.println("Person::(int age,String name)");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}