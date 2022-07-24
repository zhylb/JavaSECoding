package com.lihd3;

/**
 * 内部类
 * 分为 成员内部类(静态, 非静态) 和 局部内部类(方法, 代码块, 构造器)
 *
 * 成员内部类
 *      作为成员
 *          > 可以被static修饰
 *          > 可以被四种权限修饰符修饰
 *          > 可以调用类内部的结构
 *
 *      作为类
 *          > 可以被final修饰 表示无法被继承
 *          > 可以被abstract修饰, 表示抽象
 *          > 可以有构造器, 代码块,属性, 方法, 内部类
 *
 *
 *
 * 作为普通的程序员, 一般很少写 内部类, 但是需要见到认识
 *
 * 重点 关注的三个问题
 *      1 如何实例化 成员内部类
 *          静态 : 外部类.内部类 变量名 = new 外部类.内部类(形参列表);
 *          非静态 : 外部类.内部类 变量名  = 外部类对象.new 内部类(形参列表);
 *
 *      2 成员内部类 如何区分本类和外部类中的同名方法
 *          形参 : 不加修饰
 *          本类中 : this.
 *          外部类 中 : 外部类.this.
 *      3 开发中 如何使用局部内部类
 *          方法 : 返回一个接口的实例化对象 见 InnerClassTest1
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/21 15:46
 */
public class InnerClassTest {


    public static void main(String[] args) {
        // 1 实例化静态成员内部类

        Person.Nation n = new Person.Nation();
        n.showNation();


        // 2 实例 非静态成员内部类

        Person p = new Person();
        Person.love l1 = p.new love();
        l1.showName("!!!");

        //较为难以阅读的方式

        new Person().new love().hi();




    }
}

class Person{

    String name = "Person";
    int pa = 1;
    int pb = 2;

    public void hello(){
        System.out.println("Person::hello");
    }


    //静态成员 内部类
    protected static class Nation{
        public void showNation(){
            System.out.println("中国");
        }
    }

    //内部类 非静态
    public final class love{
        int age;
        String name = "lover";

        public void hi(){

            System.out.println(pa);
            System.out.println(Person.this.pb);

            hello();
            Person.this.show();
        }

        public void showName(String  name){
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Person.this.name);
        }


    }

    //代码块 局部内部类
    {
        class A{}
    }

    //构造器 局部内部类
    Person(){
        class B{}
    }

    //方法 局部内部类
    public void show(){
        class C{}
    }

}
