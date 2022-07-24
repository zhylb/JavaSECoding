package com.lihd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator对象称为迭代器(设计模式的一种)，主要用于遍历 Collection 集合中的元素。
 *  GOF给迭代器模式的定义为：提供一种方法访问一个容器(container)对象中各个元
 * 素，而又不需暴露该对象的内部细节。 迭代器模式，就是为容器而生。 类似于“公
 * 交车上的售票员”、“火车上的乘务员”、 “空姐” 。
 *  Collection接口继承了java.lang.Iterable接口，该接口有一个iterator()方法，那么所
 * 有实现了Collection接口的集合类都有一个iterator()方法，用以返回一个实现了
 * Iterator接口的对象。
 *  Iterator 仅用于遍历集合， Iterator 本身并不提供承装对象的能力。如果需要创建
 * Iterator 对象，则必须有一个被迭代的集合。
 *  集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合
 * 的第一个元素之前
 *
 *
 * 常用方法
 * boolean		hasNext()		Returns true if the iteration has more elements.
 * E		    next()		Returns the next element in the iteration.
 * default void	remove()		Removes from the underlying collection
 *          the last element returned by this iterator (optional operation).
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/13 11:29
 */
public class IteratorTest {

    /**
     * Test03 : 数组如何使用iterator？
     * Arrays.stream(arr).iterator();
     *
     *
     *
     */
    @Test
    public void test03 (){
        String[] str = {"AA","BB","cc"};
        Iterator<String> iterator = Arrays.stream(str).iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }



    /**
     * Test02 :
     * remove() 默认方法 移除当前指针位置 指向的元素
     * 1 先next()再remove()
     * 2 不能一开始就remove()
     * 3 不能连续remove()
     *
     * 这个remove方法确实可以删除容器中的元素
     *
     *
     *
     */
    @Test
    public void test02 (){
        Collection<Integer> coll = new ArrayList<>();
        coll.add(123);
        coll.add(123);
        coll.add(456);
        coll.add(456);
        coll.add(789);
        coll.add(789);
        Iterator<Integer> iterator = coll.iterator();
        // iterator.remove(); IllegalStateException
        while(iterator.hasNext()){
            Integer next = iterator.next();
            if(next == 456){
                iterator.remove();
                // iterator.remove(); IllegalStateException
            }
        }

        iterator = coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }



    }

    /**
     * Test01 : 基本使用
     * 两个基本方法
     * 1 hasNext()判断下一个位置是否有元素
     * 2 next() 第一步指针下移，第二步返回指针对应的元素
     *
     * iterator本质上是迭代器，并没有开辟一个向容器那样大的空间
     *
     *
     */
    @Test
    public void test01 (){
        Collection<Integer> coll = new ArrayList<>();
        coll.add(123);
        coll.add(456);
        coll.add(789);

        Iterator<Integer> iterator = coll.iterator();
        while(iterator.hasNext()){//判断一个位置是否有元素
            System.out.println(iterator.next());//指针下移，返回指针所在的位置
        }

        // iterator.next(); NoSuchElementException





    }
}
