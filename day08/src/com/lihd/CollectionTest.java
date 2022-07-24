package com.lihd;

import java.util.Map;

/**
 * <p>集合框架概述</p>
 * 1 集合和数组都是对多个数据进行存储操作的结构，简称java容器（内存方面的存储，不涉及持久化）
 * 2.1 数组在存储多个数据的特点
 *      > 初始化以后，长度就确定了
 *      > 数据一旦定义好，器元素类型也就确定了，我们只能操作指定类型的数据（String[] int[] Object[]）
 *      > 数组查询的效率非常高，而 增删改 效率很低
 * 2.2 数组在存储多个数据方面的缺点 ：
 *      > 一旦初始化，长度不可改变
 *      > 数组中提供的方法非常有限，对于增删改等操作非常不便，同时效率不高
 *      > 获取数组中实际元素的个数需求，数组没有提供方法
 *      > 数组的存储特点是 ：有序，可重复，对于无序，不可重复的需求，无法满足
 *
 *
 * <p>API</p>
 * 集合框架 ：
 *      |----- Collection : 存放一个一个的对象
 *          |----- List ：存放有序，可重复的数据 “动态数组”
 *              |----- Arraylist,LinkedList,Vector
 *
 *          |----- Set : 存放无序，不可重复的数据 类似于集合
 *              |----- HashSet,LinkedHashSet,TreeSet
 *
 *      |----- Map : 存放一对一对(key - value)的对象，类似于函数 f(x) = y
 *              |----- HashMap,LinkedHashMap,TreeMap,HashTable,Properties
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/13 9:28
 */
public class CollectionTest {
    public static void main(String[] args) {

    }
}
