package com.lihd2;

/**
 * this 当前对象 或者正在创建的对象
 * 可以调用 属性,方法,构造器
 *
 * 在类的方法可以 使用"this.属性"或者"this.方法" 一般省略this 如果与形参名称冲突则必须要加上
 * 在构造器中 可以使用"this.属性"或者"this.方法" 一般省略this 如果与形参名称冲突则必须要加上
 *
 * this调用构造器
 *      1 可以显式 使用this(形参列表) 来调用本类的构造器
 *      2 不能使用 this() 调用自己, 也不能形成闭合的环路
 *      3 this()必须位于首行, 因此一个构造器至多调用 一个本类的构造器
 *      4 如果一个类有n个构造器, 那么最多有 n - 1个构造器 调用了本类的构造器 剩下的一个未必是空参构造器
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/9 21:37
 */
public class UserTest {
    public static void main(String[] args) {
        User u = new User(12,"hello");
        System.out.println(u.name);//hello
    }
}

class User{
    int age;
    String name;

    public User(){
        System.out.println("有一万行初始化代码");
    }

    public User(int age){
        this();
        this.age = age;
    }

    public User(String name){
        this();
        this.name = name;
    }

    public User(int age,String name){
        this(age);
        this.name = name;
    }

}
