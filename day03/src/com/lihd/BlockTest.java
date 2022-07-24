package com.lihd;

/**
 * 类的成员 四 : 代码块
 *
 * 用于初始化块
 *
 * 代码块分为静态代码块 和 非静态代码块
 *
 * 由于代码块随着类的加载或者对象的创建而执行, 无法从外界调用
 * 因此代码块没有必要声明多个, 有多个也可以合并成一个
 *
 * 1 静态代码块
 *      1 可以有输出语句
 *      2 随着类的加载而执行, 只会执行一次
 *      3 初始化类的信息
 *      4 可以有多个静态代码块, 执行顺序按照声明顺序
 *      5 静态代码块执行顺序早于非静态代码块
 *      6 静态代码块 只可以调用静态的属性和方法
 *
 *
 *
 * 2 非静态代码块
 *      1 可以有输出语句
 *      2 随着对象的创建而加载, 创建一次执行一次
 *      3 初始化对象的信息
 *      4 可以有多个代码块, 执行顺序按照声明顺序
 *      5 可以调用静态属性和方法 也可以调用非静态属性和方法
 *
 *
 *
 * 3 在继承中代码块的执行顺序
 *      "由父及子, 静态先行"
 *
 * 4 如果一个静态属性初始化时会抛出异常 该怎么办 ?
 *      使用静态代码块, 加上 try-catch-finally
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/19 23:29
 */
public class BlockTest {
    public static void main(String[] args) {
        //使用了类的静态结构 类已经加载 执行静态代码块
        System.out.println(Person.personId);

        new Person();
        new Person();

    }

}

class Person{
    String name;
    int age;
    static int personId;
    static {
        System.out.println("static code block 1");
    }

    static{
        System.out.println("static code block 2");
    }

    {
        System.out.println("code block 1");
    }

    {
        System.out.println("code block 2");
    }
}