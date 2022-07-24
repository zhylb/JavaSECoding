package com.lihd;

import org.junit.Test;

import java.lang.annotation.ElementType;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/17 12:51
 */
public class ClassTest {
    /**
     * Test01 : 关于java.lang.Class类的理解 以及四种获取Class运行时类的方式
     * 1 类的加载过程
     *      程序经过javac.exe命令后，会生成一个或多个字节码文件（.class）
     *      接着使用java.exe命令对某个字节码文件进行解释运行，相当于将某个字节码文件加载到内存中，
     *      此过程为类的加载，加载到内存中的类，我们就称为运行时类，此运行时类，就作为Class的一个实例
     * 2 换句话说，Class的实例就对应着一个运行时类
     * 3 加载到内存的运行时类，会缓存一定的时间，在此时间之内，我们可以通过不同的方式来获取此运行时类
     *
     */
    @Test
    public void test01 () throws ClassNotFoundException {
        //1 类名.class属性
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        //2 任何一个对象.getClass()方法
        Class<? extends Person> clazz2 = new Person().getClass();
        System.out.println(clazz2);

        //3 Class.forName(String name);
        Class<?> clazz3 = Class.forName("com.lihd.Person");
        System.out.println(clazz3);

        //4 ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.lihd.Person");
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz2);//true
        System.out.println(clazz1 == clazz4);//true


    }

    /**
     * Test02 : 什么可以充当Class的对象
     *  1） class：外部类， 成员(成员内部类， 静态内部类)， 局部内部类， 匿名内部类
     * （2） interface： 接口
     * （3） []：数组
     * （4） enum：枚举
     * （5） annotation：注解@interface
     * （6） primitive type：基本数据类型
     * （7） void
     *
     *
     */
    @Test
    public void test02 (){
        Class<Object> c1 = Object.class;
        Class<Comparable> c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class<Void> c8 = void.class;
        Class c9 = Class.class;
        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }

}
