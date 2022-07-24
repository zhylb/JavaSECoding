package com.lihd2;

import com.lihd.Person;
import com.lihd1.Son;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/17 19:36
 */
public class ReflectionTest {
    /**
     * Test01 : 调用类的属性
     *
     *
     *
     */
    @Test
    public void test01 ()throws Exception{
        Class<Son> clazz = Son.class;
        //0 实例化对象
        Son instance = clazz.newInstance();

        //1 调用非静态属性
        Field age = clazz.getDeclaredField("age");

        //2 设置连通性 (如果不是public的属性或方法就必须用setAccessible(true) )
        age.setAccessible(true);
        //3 使用 Field.set(对象, 要设置的对象)
        age.set(instance,99);
        //4 获取对象的值，返回值object ,
        Object o = age.get(instance);
        System.out.println(o);

        //*********************************
        //调用静态属性
        //1 getDeclaredFiled获取静态属性
        Field staticNum = Son.class.getDeclaredField("staticNum");
        //2 设置连通性
        staticNum.setAccessible(true);
        //3 设置值，由于是静态的，与对象没有关系，所有Object obj这个位置可以随便写
        staticNum.set(null,500);
        //4 获取值 由于是静态的，与对象没有关系，所有Object obj这个位置可以随便写，new String都行
        Object o1 = staticNum.get(new String());
        System.out.println(o1);


    }


    /**
     * Test02 : 调用类的方法
     *
     *
     *
     */
    @Test
    public void test02 ()throws Exception{
        Class<Son> clazz = Son.class;
        //*********************************
        //调用非静态方法
        //0 实例化对象
        Son instance = clazz.newInstance();
        //1 获取方法
        // getDeclaredMethod(String 方法名, Class可变形参 ：参数列表)
        Method sonPrivate = clazz.getDeclaredMethod("sonPrivate", int.class);

        //2 设置连通性
        sonPrivate.setAccessible(true);

        //3 调用方法 method.invoke(对象，对象形参列表)
        // invoke()返回值即为方法返回值，如果原方法返回void,则invoke()返回null;
        Object invoke = sonPrivate.invoke(instance, 55);
        System.out.println("invoke = " + invoke);

        //*********************************
        //调用非静态方法
        //1 获取静态属性
        Method show = Son.class.getDeclaredMethod("show", String.class);
        //2 设置连通性
        show.setAccessible(true);
        //3 调用方法
        Object invoke1 = show.invoke(null, "hello");
        System.out.println("invoke1 = " + invoke1);//由于原方法没有返回值，因此返回null


    }


    /**
     * Test03 : 调用构造器
     * 了解就行
     * 绝大部分情况下使用 clazz.newInstance()即可
     * 只是作为补充
     */
    @Test
    public void test03 () throws Exception{
        Class<Son> clazz = Son.class;
        //0 getDeclaredConstructor(Class... 形参列表)
        //比方法少了一个方法名，因为构造器的名字肯定和类相同
        Constructor<Son> constructor = clazz.getDeclaredConstructor(String.class);
        //2 设置连通性
        constructor.setAccessible(true);
        //3 newInstance(形参列表)
        Son son = constructor.newInstance("李白");
        System.out.println(son);//Son{age=0, id=0, school='null', name='李白'}
    }

}
