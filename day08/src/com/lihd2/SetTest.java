package com.lihd2;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * |----- Set : 无序 不可重复的数据
 *      |----- HashSet Set的主要实现类，线程不安全，效率高，可以存放null值
 *          |----- LinkedHashSet HashSet的子类，增加前后指针，可以实现遍历顺序与输入顺序相同，对于频繁的遍历，效率高
 *      |----- TreeSet 可以对添加的对象进行排序，底层采用红黑树 比较相等的方法是compare 而不是equals()
 *
 *
 * set中没有定义新的方法

 * 如何理解Set 底层采用数组
 *  1 何为无序 ：并非随机性，添加的顺序并非索引顺序，而是对象哈希值根据某种确定的算法来分配索引，因此无序
 *              此处的无序也与遍历的顺序没哟关系，因为遍历顺序可以通过其他手段实现（前后指针）
 *
 *  2 何为不可重复 ：相同的元素只能添加一次，那么具体是怎么实现的呢？
 * 添加过程 ：
 *     1 hashMap.add(a),首先计算a.hashCode(),根据某种确定的算法（散列函数，对这个函数要求高）计算出位于数组中的位置，然后进行判断
 *          如果该位置有元素 ：首先比较 a.hashCode()与该位置所有元素的哈希值是否相等
 *              如果相等 ：a调用equals()方法，把这个位置上的与a哈希值相等的对象传入
 *                  equals() == ture : 添加失败
 *                  equals() == false : 添加成功
 *              如果不相等 ：添加成功
 *          如果没有元素 ：添加成功
 *
 * 对于添加成功的情况并且这个位置已经有了元素
 *      在jdk7中，新加入的元素指向之前的元素 ：七上
 *      在jdk8中，之前的元素指向新添加的元素 ：八下
 * 因此放入set中的数据要重写 hashCode()和 equals()方法，书写要求：两个方法要保持一致性 equals相等的对象hash值必须相等
 *      也就是判断相等的属性，一定要参与哈希值的计算
 *
 * 为什么重写的时候会出现31
 *  result = 31 * result + age;
 *  因为 ：
 *       选择系数的时候要选择尽量大的系数。因为如果计算出来的hash地址越大，所谓的“冲突”就越少，查找起来效率也会提高。（减少冲突）
 *       并且31只占用5bits,相乘造成数据溢出的概率较小。
 *       31可以 由i*31== (i<<5)-1来表示,现在很多虚拟机里面都有做相关优化。 （提高算法效率）
 *       31是一个素数，素数作用就是如果我用一个数字来乘以这个素数，那么最终出来的结果只能被素数本身和被乘数还有1来整除！ (减少冲突)
 *
 *
 * LinkedHashSet加入了前后指针，对于频繁的遍历操作，效率高，也可以试下按照输入顺序输出(并不是有序哦)
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/13 19:13
 */
public class SetTest {


    /**
     * Test02 :
     *
     *
     *
     */
    @Test
    public void test02 (){
        Set set = new LinkedHashSet();
        set.add("Hello");
        set.add(789);
        set.add(123);
        set.add(new Person("libai",78));
        set.add(new Person("libai",78));

        System.out.println(set);//[Hello, 789, 123, Person{name='libai', age=78}]
    }
    /**
     * Test01 :
     *
     *
     *
     */
    @Test
    public void test01 (){
        Set set = new HashSet();
        set.add("Hello");
        set.add(789);
        set.add(123);
        set.add(new Person("libai",78));
        set.add(new Person("libai",78));

        System.out.println(set);//[Person{name='libai', age=78}, Hello, 789, 123]
    }
}
