package com.lihd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 这里主要介绍Collection接口中定义的方法
 * Iterator<E>	iterator()		Returns an iterator over the elements in this collection. 以后再说
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/13 9:42
 */
public class CollectionMethodTest {

    /**
     * Test05 : 转换
     * Object[]		toArray()		Returns an array containing all of the elements in this collection.
     * <T> T[]		toArray(T[] a)		Returns an array containing all of the elements in this collection;
     *                                  the runtime type of the returned array is that of the specified array.
     */
    @Test
    public void test05 (){
        Collection<Integer> coll = new ArrayList<>();
        coll.add(123);
        coll.add(456);
        coll.add(789);
        Object[] objects = coll.toArray();
        for (Object o : objects) {
            System.out.println(o);
        }

        //Arrays.asList()
        System.out.println(Arrays.asList(123,456));//[123, 456]
        System.out.println(Arrays.asList(new int[]{123,456}));//[[I@1888ff2c]
        System.out.println(Arrays.asList(new Integer[]{123,456}));//[123, 456]


    }


    /**
     * Test04 :
     * boolean		equals(Object o)		Compares the specified object with this collection for equality.
     * int		    hashCode()		Returns the hash code value for this collection.
     */
    @Test
    public void test04(){
        Collection<Integer> coll = new ArrayList<>();
        coll.add(123);
        coll.add(456);
        coll.add(789);

        int hashCode = coll.hashCode();
        System.out.println("hashCode = " + hashCode);

        List<Integer> other = Arrays.asList(123,789, 456);
        System.out.println(coll.equals(other));//false 顺序不一样也不可以，因为这是list




    }




    /**
     * Test03 : 集合操作 移除操作
     * boolean		remove(Object o)		Removes a single instance of the specified element from this collection, if it is present (optional operation).
     * boolean		removeAll(Collection<?> c)		Removes all of this collection's elements that are also contained in the specified collection (optional operation).
     * boolean		retainAll(Collection<?> c)		Retains only the elements in this collection that are contained in the specified collection (optional operation).
     *
     * 似乎只要数据改变，就会返回true
     */
    @Test
    public void test03 (){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Hello");
        coll.add(new Person("libai",18));
        coll.add("Never");

        System.out.println(coll.remove(new Person("libai", 18)));//true
        System.out.println(coll);//[123, 456, Hello, Never]

        //集合操作 差集 this.removeAll(c) this = this - c
        boolean removeAll = coll.removeAll(Arrays.asList(1234, 456, "Hello"));
        System.out.println("removeAll = " + removeAll);
        System.out.println(coll);//[123, Never]

        coll.add(456);
        coll.add(789);
        System.out.println(coll);//[123, Never, 456, 789]
        //集合操作 交集 this.retainAll(c) this = this ∩ c

        List<Integer> list = Arrays.asList(123, 654, 789);
        coll.retainAll(list);
        System.out.println(coll);
        System.out.println(list);


    }


    /**
     * Test02 :
     * boolean		contains(Object o)		Returns true if this collection contains the specified element.
     * boolean		containsAll(Collection<?> c)		Returns true if this collection contains all of the elements in the specified collection.
     * 内部使用了equals方法 因此要求被存放的数据要重写equals()方法
     * 会调用 传入参数的equals()的方法 逐个与Collection中的数据进行比较
     *
     * this.containsAll(c)类似于集合中的包含关系 即 c是否是a的子集
     */
    @Test
    public void test02 (){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Hello");
        coll.add(new Person("libai",18));
        coll.add("Never");

        System.out.println(coll.contains(new String("Hello")));
        System.out.println(coll.contains(new Person("libai",18)));


        List<Integer> list = Arrays.asList(123, 456);
        System.out.println(list.getClass());
        System.out.println(coll.containsAll(list));

    }



    /**
     *
     * boolean		add(E e)		Ensures that this collection contains the specified element (optional operation).
     * boolean		addAll(Collection<? extends E> c)		Adds all of the elements in the specified collection to this collection (optional operation).
     * void		    clear()		Removes all of the elements from this collection (optional operation).
     * boolean		isEmpty()		Returns true if this collection contains no elements.
     * int		    size()		Returns the number of elements in this collection.
     *
     */
    @Test
    public void test01 (){
        Collection coll = new ArrayList();

        coll.add("Hello");
        coll.add(34.7);
        coll.add(89);

        System.out.println(coll.size());//3

        Collection list = new ArrayList();
        list.add(111);
        list.add("CC");

        coll.add(list);//list作为一个数据
        coll.addAll(list);//list中的每个数据作为一个数据
        System.out.println(coll.size());//6

        System.out.println(coll);

        System.out.println(coll.isEmpty());
        coll.clear();
        System.out.println(coll.isEmpty());


    }


}
