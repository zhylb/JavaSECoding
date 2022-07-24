package com.lihd3;

import org.junit.Test;

import java.util.*;

/**
 * <p>Map的体系结构</p>
 * |----- Map : 存储一对一对的数据（key-value）,类似于函数
 *      |----- HashMap : 作为Map的主要实现类，线程不安全，效率高，key-value都可以存放null值
 *          |----- LinkedHashMap : 添加了前后指针，可以按照添加顺序遍历，对于频繁的遍历效率高
 *      |----- TreeMap : 保证按照添加的key-value进行排序，需要compareTo方法，底层采用红黑树
 *      |----- Hashtable : 作为Map的古老实现类，线程安全，效率低，key-value都不可以存放null值
 *          |----- Properties : 常用来处理配置文件，key-value都是String
 *
 *    HashMap的底层 ： jdk7 : 数组 + 链表
 *                 ： jdk8 ：数组 + 链表 + 红黑树
 *  常见面试题 ：
 *          1 HashMap底层实现原理
 *          2 HashMap与Hashtable的异同
 *          3 CurrentMap与Hashtable的异同
 * Map结构的理解
 *      Map的组成是 key - value
 *      具体在内存中是由一个 Entry<key,value>组成
 *      key -> 无序不重复 ： 所在的类要重写 hashCode 和 equals()
 *      value -> 随着key附加，无序可重复 ：所在的类要重写 equals()（因为有containsValue()这个方法）
 *
 * JDK7 ：Map存放数据流程
 *      HashMap map = new HashMap()//底层创建了一个 长度为16的Entry数组 table[]
 *      map.put(key1,value1)
 *      首先key1.hashCode() & 15 计算出位于数组中的索引（未扩容之前），然后判断这个位置上是否有元素
 *      如果没有 ：插入成功
 *      如果有 ： key1.hashCode()与这个位置上所有的hashCode()进行比较
 *          如果都不相等 ：插入成功
 *          如果 key2,value2的key1.hashCode()与 key2.hashCode() ：key1.equals(key2)
 *              如果为假 ：插入成功
 *              如果为真 ：表现出替换功能 ： 使用 value1替换掉value2
 *      总而言之，put后的结果一定是有改变的
 *      在put的过程中会设计到扩容，扩容为原理的两倍
 * JDK8中的改变
 *      1 new HashMap()时，没有创建一个长度为16的数组
 *      2 底层的数组是 Node[]而非 Entry[]
 *      3 首次调用put方法时，底层创建长度为16的数组
 *      4 jdk7底层结构 ：数组 + 链表 （新添加的节点指向之前的链表）
 *        jdk8底层结构 ：数组 + 链表 (之前的节点指向新添加的节点)+ 红黑树
 *        当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8并且 当前数组长度 > 64 （如果不大于64就去resize()扩容）
 *        此时此索引位置改为用红黑树存储。O(N) -> O(logN)
 * 重要常量
 * DEFAULT_INITIAL_CAPACITY : HashMap的默认容量， 16
 * MAXIMUM_CAPACITY ： HashMap的最大支持容量， 2^30
 * DEFAULT_LOAD_FACTOR： HashMap的默认加载因子
 * TREEIFY_THRESHOLD： Bucket中链表长度大于该默认值，转化为红黑树
 * UNTREEIFY_THRESHOLD： Bucket中红黑树存储的Node小于该默认值，转化为链表
 * MIN_TREEIFY_CAPACITY： 桶中的Node被树化时最小的hash表容量。（当桶中Node的
 * 数量大到需要变红黑树时，若hash表容量小于MIN_TREEIFY_CAPACITY时，此时应执行
 * resize扩容操作这个MIN_TREEIFY_CAPACITY的值至少是TREEIFY_THRESHOLD的4
 * 倍。）
 * table： 存储元素的数组，总是2的n次幂
 * entrySet： 存储具体元素的集
 * size： HashMap中存储的键值对的数量
 * modCount： HashMap扩容和结构改变的次数。
 * threshold： 扩容的临界值， =容量*填充因子
 * loadFactor： 填充因子
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/14 9:44
 */
public class MapTest {


    /**
     * Test00:
     *
     * HashMap可以存放null的key和value
     * 而HashTable既不能存放null的key，也不能存放null的value
     *
     */
    @Test
    public void test00 (){
        HashMap map = new HashMap();
        map.put(null,null);

        Hashtable hashtable = new Hashtable();
        hashtable.put(null,"aa");
        hashtable.put("bb",null);
    }

    /**
     * Test01 : 看一下扩容
     *
     * 第一次 put() -> putVal() -> resize()
     * 其中初始化了两个属性，并且创建了数组
     * newCap = DEFAULT_INITIAL_CAPACITY;
     * newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
     * Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
     *
     * final Node<K,V>[] resize() {
     *
     * resize()中还有一个扩容代码 扩容为原来的两倍，也就是说数组的长度是二的指数幂
     * 扩容为原来的两倍 newThr = oldThr << 1; // double threshold
     * 那么除了第一次put时扩容，什么时候还会扩容
     * if (++size > threshold)
     *             resize();
     * 也就是说 长度 > threshold时，扩容
     *
     *
     *
     */
    @Test
    public void test01 (){
        HashMap map = new HashMap();
    }

    /**
     * Test02 : 看一下怎么put
     *
     *              Node<K,V> e; K k;
     *              //先判断是否与第一个对象hashcode和equals相等
     *             if (p.hash == hash &&
     *                 ((k = p.key) == key || (key != null && key.equals(k))))
     *                 e = p;//相等就赋值
     *             再看一看是否是一个树形结构
     *             else if (p instanceof TreeNode)
     *                 e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
     *             else {
     *             现在才开始for循环
     *                 for (int binCount = 0; ; ++binCount) {
     *                 先看一下是否是空 是空的时候就加入
     *                     if ((e = p.next) == null) {
     *                         p.next = newNode(hash, key, value, null);
     *                         添加时先看一下是否要变成红黑树
     *                         if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
     *                             treeifyBin(tab, hash);
     *                         break;
     *                     }
     *                     再看一下是否相等，
     *                     if (e.hash == hash &&
     *                         ((k = e.key) == key || (key != null && key.equals(k))))
     *                         break;
     *                     如果两个都没进去，p = e. e = p.next开始下一轮
     *                     p = e;
     *                 }
     *             }
     *             用新的值替换旧的值
     *             if (e != null) { // existing mapping for key
     *                 V oldValue = e.value;
     *                 if (!onlyIfAbsent || oldValue == null)
     *                     e.value = value;
     *                 afterNodeAccess(e);
     *                 return oldValue;
     *             }
     *
     *
     */
    @Test
    public void test02 (){

    }

    /**
     * Test03 : 看一下LinkedHashMap();
     * 重写了父类中的newNode方法,这个方法中新建的节点为 Entry
     * new LinkedHashMap.Entry<>(hash, key, value, e);
     *
     * 这个节点声明如下，继承与父类HashMap中的HashMap.Node,并且赋予了前后指针 before,after因此可以实现遍历顺序与输入顺序相同
     * static class Entry<K,V> extends HashMap.Node<K,V> {
     *         Entry<K,V> before, after;
     *         Entry(int hash, K key, V value, Node<K,V> next) {
     *             super(hash, key, value, next);
     *         }
     *     }
     *
     */
    @Test
    public void test03 (){
        Map map = new LinkedHashMap();
    }



    /**
     * Test04 : 再看一下hashSet
     * HashSet其实是HashMap实现
     * public HashSet() {
     *         map = new HashMap<>();
     *     }
     * 添加方法add也就是map.put()
     * 那为什么set中没有替换值呢？其实有，因为set对于的map的value是一个常量 PRESENT
     * public boolean add(E e) {
     *         return map.put(e, PRESENT)==null;
     *     }
     * 这个常量可不是 null哦，是一个没有意义的值，所有的key指向了同一个value，由于一个引用在32位4个字节，64位机器8个字节，因此可能每个对象浪费8个字节
     * private static final Object PRESENT = new Object();
     *
     */
    @Test
    public void test04 (){
        HashSet set = new HashSet();
    }



}
