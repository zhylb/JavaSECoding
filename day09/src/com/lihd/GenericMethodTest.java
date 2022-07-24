package com.lihd;

import java.util.ArrayList;

/**
 * 泛型方法 ：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
 * 换句话说 泛型方法所属的类是不是泛型类都没有关系
 *
 * 泛型方法可以声明为静态的，因为在泛型参数是在调用方法是确定的，而非在实例化时确定的。
 *
 * 1 泛型方法 1 ：将数组转换为 list
 * 2 泛型方法 2 ：根据类名获取一个类的对象
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/15 17:29
 */
public class GenericMethodTest {

    public static void main(String[] args) {
        String[] arr = {"AA","BB","CC","DD","EE"};
        ArrayList<String> strings = arrToList(arr);
        System.out.println(strings);

        String object = getObject(String.class);

    }


    public static <T> ArrayList<T> arrToList(T[] arr){
        ArrayList<T> list = new ArrayList<>();
        for (T t : arr) {
            list.add(t);
        }
        return list;
    }

    public static <T> T getObject(Class<T> clazz){
        T t = null;
        try {
            t = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }
}
