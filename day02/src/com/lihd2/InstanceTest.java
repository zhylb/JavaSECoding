package com.lihd2;

/**
 * 子类实例化过程
 * 1 从结果上来看 继承性
 *      子类继承父类后, 就获取了父类中所有的方法和属性
 *      创建子类的对象, 在堆空间中, 就会加载父类声明的属性
 * 2 从过程上来看
 *      当我们创建子类对象时, 一定会直接或间接调用父类的构造器, 进而调用父类的父类的构造器...
 *      直到调用了java.lang.Object的空参构造器为止, 正因为加载了父类的结构, 所以可以在内存中看到父类的结构
 *      子类对象才可以考虑调用
 * 3 强调说明
 *      虽然调用了很多构造器 但是自始至终就创建了一个对象
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/18 11:17
 */
public class InstanceTest {
    public static void main(String[] args) {

        //无论如何都会调用父类的构造器

        Son s = new Son();

        System.out.println("-----------");
        Son s1 = new Son(1,2);

        System.out.println("-----------");

        Son s2 = new Son("hello");

        System.out.println("-----------");
        Son s3 = new Son(1,"1",1);

    }




}
