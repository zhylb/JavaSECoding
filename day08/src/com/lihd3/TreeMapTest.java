package com.lihd3;

import org.junit.Test;

import java.util.*;

/**
 * 要求要有compareTo方法
 * 可以是类实现，也可以是传入comparator
 * 如果compareTo方法返回0表示相等
 * 返回0比较有意思
 *      1 key的值采用先来后到 （TreeSet也是）
 *      2 value的值会采用后来的，即有更新的意思
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/14 17:05
 */
public class TreeMapTest {

    /**
     * Test03 : 更新操作
     *
     *
     *
     */
    @Test
    public void test03 (){
        //直接按年龄排序，年龄一样的我不要了
        Map<Person,Integer> map = new TreeMap(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.age,o2.age);
            }
        });

        Person p1 = new Person("AA",33);
        Person p2 = new Person("BB",33);
        Person p3 = new Person("CC",33);
        Person p4 = new Person("DD",28);
        Person p5 = new Person("FF",28);

        map.put(p1,1);
        map.put(p2,100);
        map.put(p3,1000);
        map.put(p4,8);
        map.put(p5,88);
        //你能想出输出结果吗
        //Person{name='DD', age=28} ---> 88
        //Person{name='AA', age=33} ---> 1000

        Set<Map.Entry<Person, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Person, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<Person, Integer> next = iterator.next();
            System.out.println(next.getKey() + " ---> " + next.getValue());
        }


    }



    /**
     * Test02 : 订制排序
     * 先按姓名倒着排序，再按年龄倒着排序
     *
     *
     */
    @Test
    public void test02 (){
        Map<Person,Integer> map = new TreeMap(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int compareTo = o1.name.compareTo(o2.name);
                if(compareTo == 0){
                    return - Integer.compare(o1.age,o2.age);
                }else {
                    return -compareTo;
                }
            }
        });
        Person p1 = new Person("AA",33);
        Person p2 = new Person("BB",33);
        Person p3 = new Person("CC",19);
        Person p4 = new Person("BB",20);
        Person p5 = new Person("AA",20);
        map.put(p1,12);
        map.put(p2,51);
        map.put(p3,96);
        map.put(p4,31);
        map.put(p5,47);


        Set<Map.Entry<Person, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Person, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<Person, Integer> next = iterator.next();
            System.out.println(next.getKey() + " ---> " + next.getValue());
        }
    }



    /**
     * Test01 : 自然排序
     *
     *
     *
     */
    @Test
    public void test01 (){
        Map<Person,Integer> map = new TreeMap();
        Person p1 = new Person("AA",33);
        Person p2 = new Person("BB",33);
        Person p3 = new Person("CC",19);
        Person p4 = new Person("BB",20);
        Person p5 = new Person("AA",20);
        map.put(p1,12);
        map.put(p2,51);
        map.put(p3,96);
        map.put(p4,31);
        map.put(p5,47);


        Set<Map.Entry<Person, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Person, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<Person, Integer> next = iterator.next();
            System.out.println(next.getKey() + " ---> " + next.getValue());
        }

    }

}
