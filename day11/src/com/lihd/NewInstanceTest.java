package com.lihd;

import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射创建运行时类的对象
 * clazz.newInstance();
 * 要求 1 运行时类提供空参构造器
 *     2 空参构造器的访问权限充足（设置为public肯定行）
 *
 * 回忆JavaBean
 * 要求提供 public的空参构造器
 * 好处
 *      1 便于反射创建运行时类的对象
 *      2 便于子类使用空参构造器时调用super()，父类有此构造器
 * 可惜这个方法已经过时了
 * This method propagates any exception thrown by the nullary constructor, including a checked exception.
 * Use of this method effectively bypasses the compile-time exception checking that would otherwise
 * be performed by the compiler. The Constructor.newInstance method avoids this problem by wrapping any exception
 * thrown by the constructor in a (checked) InvocationTargetException.
 * The call
 *   clazz.newInstance()
 * can be replaced by
 *   clazz.getDeclaredConstructor().newInstance()
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/17 12:18
 */
public class NewInstanceTest {
    public static void main(String[] args)  {
        Class<Person> clazz = Person.class;
        Person person = null;
        try {
            person = clazz.newInstance();
            System.out.println(person);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Person p = null;
        try {
            p = clazz.getDeclaredConstructor().newInstance();
            System.out.println(p);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
