package com.lihd3;

import org.junit.Test;

import java.util.*;

/**
 * Collections是操作Collection , Map的工具类
 * 使用方法
 * Collections.xxxXxx()
 * 把一个线程不安全的类转换为线程安全的类
 * xxx synchronizedXxx()
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/14 20:44
 */
public class CollectionsTest {

    /**
     * Test04 : 把一个线程不安全的类转换为线程安全的类
     * 在Collections中定义
     * private static class SynchronizedMap<K,V>
     * final Object      mutex;充当同步锁
     *
     * 所有的方法被上了一个锁，相当于代理了一下
     * public V put(K key, V value) {
     *             synchronized (mutex) {return m.put(key, value);}
     *
     *
     */
    @Test
    public void test04 (){
        HashMap<String,String> map = new HashMap();
        map.put("AA","11");
        map.put("BB","22");
        map.put("CC","33");
        //好处是当一个map本来不需要同步，后来需要同步后，可以直接调用此方法
        Map<String, String> stringStringMap = Collections.synchronizedMap(map);
        System.out.println(stringStringMap.size());
        System.out.println(stringStringMap);

        Iterator<Map.Entry<String, String>> iterator = stringStringMap.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }




        System.out.println(stringStringMap.getClass());//class java.util.Collections$SynchronizedMap

    }

    /**
     * Test03 :
     *
     * boolean replaceAll(List list， Object oldVal， Object newVal)： 使用新值替换List 对象的所有旧值
     *
     */
    @Test
    public void test03 (){
        List<Integer> list = new ArrayList<>();
        list.add(-3);
        list.add(7);
        list.add(0);
        list.add(-1);
        list.add(3);

        //copy的错误写法
//        List l = new ArrayList(list.size());
//        Collections.copy(l,list); //Source does not fit in dest

        //标准写法
        List des = new ArrayList();
        des = Arrays.asList(new Integer[list.size()]);
        Collections.copy(des,list);
        System.out.println(des);

    }


    /**
     * Test02 :
     * 查找、替换
     * Object max(Collection)： 根据元素的自然顺序，返回给定集合中的最大元素
     * Object max(Collection， Comparator)： 根据 Comparator 指定的顺序，返回
     * 给定集合中的最大元素
     * Object min(Collection)
     * Object min(Collection， Comparator)
     * int frequency(Collection， Object)： 返回指定集合中指定元素的出现次数
     * void copy(List dest,List src)：将src中的内容复制到dest中
     *
     */
    @Test
    public void test02 (){
        List<Integer> list = new ArrayList<>();
        list.add(-3);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(0);
        list.add(-1);
        list.add(3);

        Integer max = Collections.max(list);
        Integer min = Collections.min(list);
        int frequency = Collections.frequency(list, 7);
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("frequency = " + frequency);

        System.out.println(list);
        Collections.replaceAll(list,7,3);
        System.out.println(list);


    }


    /**
     * Test01 :
     * 下面的方法均为更改器方法 mutator method ，对一个对象进行改变
     * 排序操作： （均为static方法）
     * reverse(List)： 反转 List 中元素的顺序
     * shuffle(List)： 对 List 集合元素进行随机排序
     * sort(List)： 根据元素的自然顺序对指定 List 集合元素按升序排序
     * sort(List， Comparator)： 根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
     * swap(List， int， int)： 将指定 list 集合中的 i 处元素和 j 处元素进行交换
     *
     *
     */
    @Test
    public void test01 (){
        List<Integer> list = new ArrayList<>();
        list.add(-3);
        list.add(7);
        list.add(0);
        list.add(-1);
        list.add(3);
        System.out.println(list);
        //排序
        Collections.sort(list);
        System.out.println(list);
        //反转
        Collections.reverse(list);
        System.out.println(list);
        //交换
        Collections.swap(list,0,list.size() - 1);
        System.out.println(list);
        //洗牌
        Collections.shuffle(list);
        System.out.println(list);

    }
}
