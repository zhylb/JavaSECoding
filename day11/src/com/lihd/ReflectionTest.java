package com.lihd;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Reflection（反射）是被视为动态语言的关键，反射机制允许程序在执行期
 * 借助于Reflection API取得任何类的内部信息，并能直接操作任意对象的内
 * 部属性及方法。
 * 加载完类之后， 在堆内存的方法区中就产生了一个Class类型的对象（ 一个
 * 类只有一个Class对象） ， 这个对象就包含了完整的类的结构信息。 我们可
 * 以通过这个对象看到类的结构。 这个对象就像一面镜子， 透过这个镜子看
 * 到类的结构， 所以， 我们形象的称之为： 反射
 *
 *  Java反射机制提供的功能
 * 在运行时判断任意一个对象所属的类
 * 在运行时构造任意一个类的对象
 * 在运行时判断任意一个类所具有的成员变量和方法
 * 在运行时获取泛型信息
 * 在运行时调用任意一个对象的成员变量和方法
 * 在运行时处理注解
 * 生成动态代理
 *
 *  java.lang.Class:代表一个类
 *  java.lang.reflect.Method:代表类的方法
 *  java.lang.reflect.Field:代表类的成员变量
 *  java.lang.reflect.Constructor:代表类的构造器
 *
 * 面试题 ：
 * 1 通过new方式和反射的方式都可以获取公共的结构，开发中到底用哪个
 *      一般用new方式不用反射
 *      当需要动态性时就必须用反射了
 * 2 反射机制和面向对象中的封装性是不是矛盾的，如何看待两个技术
 *      不矛盾
 *      封装性可以把不该暴露的结构方法隐藏起来，提供有用的公共方法，封装性保证了调用者对对象的正确使用
 *      而反射更像一种能不能，我可以获取你的私有 结构，但是用这些私有的方法大部分情况下不会比其提供的方法好
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/17 9:28
 */
public class ReflectionTest {

    /**
     * Test01 : 反射之前
     *
     *
     *
     */
    @Test
    public void test01 (){
        Person p = new Person(11);
        System.out.println(p);
        p.intDefault = 6;
        p.methodPublic();
        System.out.println(p);

    }

    /**
     * Test02 : 反射
     * 可以做到之前做不到的事情
     *
     *
     */
    @Test
    public void test02 ()throws Exception{
        Class<Person> clazz = Person.class;

        Constructor<Person> declaredConstructor = clazz.getDeclaredConstructor(int.class, int.class);
        //私有构造器设置可见性
        declaredConstructor.setAccessible(true);
        Person person = declaredConstructor.newInstance(99, 100);
        System.out.println(person);

        Field intPrivate = clazz.getDeclaredField("intPrivate");
        intPrivate.setAccessible(true);
        intPrivate.set(person,1);

        System.out.println(person);

        Method methodPrivate = clazz.getDeclaredMethod("methodPrivate", int.class);
        methodPrivate.setAccessible(true);
        Object invoke = methodPrivate.invoke(person, 111);
        System.out.println(invoke);

    }





}
