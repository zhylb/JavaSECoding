package com.lihd3;

import org.junit.Test;

import java.util.*;

/**
 * Map中常用方法的测试
 * 增 ：put
 * 删 : remove
 * 改 : put
 * 查 : get
 * 插 : 无
 * 长度 : size
 * 遍历 : entrySet()/keySet() + get() /values()
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/14 17:04
 */
public class MapMethodTest {



    /**
     * Test01 :
     *  添加、 删除、修改操作：
     *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
     *  void putAll(Map m):将m中的所有key-value对存放到当前map中
     *  Object remove(Object key)：移除指定key的key-value对，并返回value
     *  void clear()：清空当前map中的所有数据
     */
    @Test
    public void test01 (){
        Map<String, Integer> map = new LinkedHashMap<>();
        //添加
        map.put("AA",11);
        map.put("BB",22);
        map.put("CC",33);
        System.out.println(map);
        //修改
        map.put("AA",100000);
        System.out.println(map);//{AA=100000, BB=22, CC=33}

        //这个是父类的对象哦
        Map<String,Integer> all = new HashMap<>();
        all.put("EE",7);
        all.put("FF",8);

        //添加所有的操作
        map.putAll(all);
        System.out.println(map);//{AA=100000, BB=22, CC=33, EE=7, FF=8}

        System.out.println(map.isEmpty());//false

        System.out.println(map.remove("EE"));//7
        System.out.println(map.remove("ZZ"));//null
        System.out.println(map);//{AA=100000, BB=22, CC=33, FF=8}

        //清除所有
        map.clear();
        System.out.println(map.isEmpty());//true

    }


    /**
     * Test02 :
     *  元素查询的操作：
     *  Object get(Object key)：获取指定key对应的value
     *  boolean containsKey(Object key)：是否包含指定的key
     *  boolean containsValue(Object value)：是否包含指定的value
     *  int size()：返回map中key-value对的个数
     *  boolean isEmpty()：判断当前map是否为空
     *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
     */
    @Test
    public void test02 (){
        Map<String, Integer> map = new HashMap<>();
        //添加
        map.put("AA",11);
        map.put("BB",22);
        map.put("CC",33);

        //get
        System.out.println(map.get("AA"));//11
        System.out.println(map.get("ZZ"));//null

        //containsKey(Object key)
        System.out.println(map.containsKey("AA"));//true
        System.out.println(map.containsKey("ZZ"));//false

        //containsValue(Object value)
        System.out.println(map.containsValue(33));//true
        System.out.println(map.containsValue(100));//false

        //长度
        System.out.println(map.size());//3
        //是否为空，没有元素的意思
        System.out.println(map.isEmpty());//false

    }

    /**
     * Test03 :
     *  元视图操作的方法：
     *  Set keySet()：返回所有key构成的Set集合
     *  Collection values()：返回所有value构成的Collection集合
     *  Set entrySet()：返回所有key-value对构成的Set集合
     * entry常用方法
     * getKey() 获取key
     * getValue() 获取value
     *
     */
    @Test
    public void test03 (){
        Map<String, Integer> map = new HashMap<>();
        //添加
        map.put("World",11);
        map.put("Never",22);
        map.put("Going",33);

        //keySet
        Set<String> strings = map.keySet();
        Iterator<String> stringIterator = strings.iterator();
        while (stringIterator.hasNext()){
            System.out.println(stringIterator.next());
        }

        //values() 这里的输出结果和上面的对应
        for (Integer value : map.values()) {
            System.out.println(value);
        }
        //entrySet
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() + " ---> " + next.getValue());
        }

        //keySet() + get() 效率应该比上面的差很多
        Set<String> keySet = map.keySet();
        Iterator<String> iterator1 = keySet.iterator();
        while(iterator1.hasNext()){
            String next = iterator1.next();
            System.out.println(next + " ==== " + map.get(next));
        }

    }
}
