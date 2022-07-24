package com.lihd1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 常用方法总结 ：
 * 增 ：add(Object o)
 * 删 ：remove(Object o)/remove(int index)
 * 改 ：set(int index,Object ele)
 * 查 ：get(index i) /indexOf(Object o)
 * 插 ：add(int index,Object ele)
 * 长度 ：size()
 * 遍历 ：1 iterator
 *      2 foreach
 *      3 for + size() + get()
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/13 16:00
 */
public class ListMethodTest {


    /**
     * Test03 : 遍历
     *
     *
     *
     */
    @Test
    public void test03 (){
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        //1 方法1
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //2
        for (Integer i : list) {
            System.out.println(i);
        }

        //3
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }


    /**
     * Test02 :
     * int indexOf(Object obj):返回obj在集合中首次出现的位置
     * int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
     * Object remove(int index):移除指定index位置的元素，并返回此元素
     * Object set(int index, Object ele):设置指定index位置的元素为ele
     */
    @Test
    public void test02 (){
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println(list);
        int indexOf = list.indexOf(2);
        int lastIndexOf = list.lastIndexOf(2);
        System.out.println("indexOf = " + indexOf);
        System.out.println("lastIndexOf = " + lastIndexOf);

        // list.remove(int index) 为什么不是移除值，
        // 因为我不用装箱就能调用出一个remove(index)的方法，为什么还要装箱remove(Integer)
        list.remove(2);//移除角标为2的元素
        System.out.println(list);//[1, 2, 2, 1]
        // list.remove(Object o) 我们给他装个箱 就可以调用remove(Object)了
        list.remove(new Integer(2));//移除元素值为2的第一个元素
        System.out.println(list);//[1, 2, 1]

        list.set(1,99);
        System.out.println(list);//[1, 99, 1]

    }



    /**
     * Test01 :
     * void add(int index, Object ele):在index位置插入ele元素
     * boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
     * Object get(int index):获取指定index位置的元素
     * List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合 左闭右开
     */
    @Test
    public void test01 (){
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.add(1,99);
        System.out.println(list);//[1, 99, 2, 3]
        list.addAll(0, Arrays.asList(9,8,7));
        System.out.println(list);//[9, 8, 7, 1, 99, 2, 3]
        // list.add(Arrays.asList(12,36)); 过不了编译
        Integer get = list.get(4);
        System.out.println("get = " + get);//get = 99

        List<Integer> s = list.subList(3, 7);
        System.out.println(list);//[9, 8, 7, 1, 99, 2, 3] 原来的list没有变化
        System.out.println(s);//[1, 99, 2, 3] 左闭右开


    }
}
