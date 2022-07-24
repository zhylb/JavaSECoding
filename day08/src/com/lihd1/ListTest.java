package com.lihd1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * List(1.2) : 可变数组，存放有序可重复的数据<br>
 *      |----- ArrayList(1.2) 作为List的主要实现类 线程不安全，效率高 底层使用Object[]
 *      |----- LinkedList(1.2) 底层使用双向链表 Node<E>
 *      |----- Vector(1.0) 作为List的古老实现类 线程安全，效率低 vector实现的List接口是后来1.2新增的，
 *                  一朝皇帝一朝臣，Vector甚至有被废弃的可能 底层使用Object[]
 *
 * ArrayList 源码分析
 * 在jdk7 中
 *      ArrayList l = new ArrayList()//底层 elementData = new Object[10]
 *      l.add(123)  elementData[0] = new Integer(123)
 *      ...
 *      l.add(789) 扩容时 扩容为原来的1.5倍 new = old + old >> 2
 * 在jdk8 以后（先不着急new数组,什么时候add,什么时候创建，节省空间）
 *      ArrayList l = new ArrayList()//底层 elementData = {} 延迟创建 Constructs an empty list with an initial capacity of ten.
 *      l.add(123) elementData = new Object[10] elementData[0] = new Integer(123)
 *      ...
 *      l.add(789) 扩容时 扩容为原来的1.5 倍
 *      int newCapacity = ArraysSupport.newLength(oldCapacity,
 *                     minCapacity - oldCapacity,  /* minimum growth 最小增长
 *                      oldCapacity>>1           /* preferred growth 首选增长);
 *
 *
 * LinkedList 源码分析
 *      内部类Node,双向链表的节点，不再具体分析
 *      private static class Node<E> {
 *         E item;
 *         Node<E> next;
 *         Node<E> prev;
 *
 *         Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 *
 * Vector源码分析
 *      即使在java17中也是
 *      Vector v = new Vector() -> new elementData[10] 没有进行优化
 *      扩容方面 7,8.17扩容为原来的两倍 但是好像被优化过，下面是17中的代码
 *      int newCapacity = ArraysSupport.newLength(oldCapacity,
 *  *                 minCapacity - oldCapacity, /* minimum growth
 *  *      capacityIncrement>0?capacityIncrement:oldCapacity /* preferred growth
 *
 *
 *
 * 启发 ：可以使用 new ArrayList(initialCapacity) 用来初始化
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/13 15:05
 */
public class ListTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        List list1 = new Vector();
        List list2 = new LinkedList();
    }
}
