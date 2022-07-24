package com.lihd1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/15 18:40
 */
public class WildcardsTest {

    /**
     * Test04 : 假泛型，类型擦除
     *
     *
     *
     */
    @Test
    public void test04 (){
        Class a = new ArrayList<Integer>().getClass();
        Class b = new ArrayList<String>().getClass();

        System.out.println(a == b);//true
    }


    /**
     * Test03 : 统配符 ？ 的具体使用
     * （没有 extends A super B这种联合的哦，就这两种）
     * 如果 类A是类B的父类，而类B又是类C的父类，那么有
     * G<? extends B> ，可以作为 G<B> G<C>的父类 可以理解为 <=
     * G<? super B> ，可以作为 G<B> G<A>的父类  可以理解为 >=
     * 记忆 ：字母e在字母s的前面，两者刚好形成  e<= =>s
     *
     *
     *
     * add()                            get()
     * (-∞          ? extends CC        CC]  只能获取数据
     * [CC          ? super   CC        +∞ )    只能添加数据
     *
     * PECS原则
     * 如果要从集合中读取类型T的数据，并且不能写入，可以使用 ? extends 通配符；(Producer Extends)
     * 如果要从集合中写入类型T的数据，并且不需要读取，可以使用 ? super 通配符；(Consumer Super)
     * 如果既要存又要取，那么就不要使用任何通配符。
     *
     */
    @Test
    public void test03 (){
        List<AA> listAA = new ArrayList<>();
        List<BB> listBB = new ArrayList<>();
        List<CC> listCC = new ArrayList<>();
        List<DD> listDD = new ArrayList<>();
        List<EE> listEE = new ArrayList<>();

        List<? super CC> listSuper = new ArrayList<>();
        List<? extends CC> listExtends = new ArrayList<>();

        listSuper = listAA;
        listSuper = listBB;
        listSuper = listCC;
//        listSuper = listDD;
//        listSuper = listEE;
//
//        listExtends = listAA;
//        listExtends = listBB;
        listExtends = listCC;
        listExtends = listDD;
        listExtends = listEE;


        //listSuper 只能添加数据
        listSuper.add(new CC());
        Object object = listSuper.get(0);
        System.out.println(object);

        //listExtends 只能取数据
        listExtends.add(null);
        CC cc = listExtends.get(0);
        System.out.println(cc);



    }



    /**
     * Test02 : 通配符的使用 ?
     *
     * 其中 A > B > C > D > E 是继承关系，可见SomeClass.java
     *
     * 类A是类B的父类
     * 那么 G<A> 和 G<B>是平级关系，他们的父类是 G<?>
     *
     * List<?>
     *     1 get() ---> 返回 Object
     *     2 add() ---> 只能添加null
     *
     *
     */
    @Test
    public void test02 (){
        List<AA> alist = Arrays.asList(new AA(),new AA());
        List<BB> blist = Arrays.asList(new BB(),new BB());

        List<?> list = null;
        list = alist;
        list = blist;



        Object o = list.get(0);

//        list.add(new AA());
//        list.add(new BB());
//        list.add(new Object());

        list.add(null);

    }


    /**
     * Test01 :
     * 如果类A是类B的父类，那么有以下结论
     * A<G> 是 B<G> 的父类
     * G<A> 和 G<B> 没有任何关系，那我如果想找一个他们的父类该怎么办
     */
    @Test
    public void test01 (){
        Object o = null;
        String s = null;
        o = s;

        Object[] objArr = null;
        String[] strArr = null;
        objArr = strArr;

        List<Object> objList = null;
        List<String> strList = null;

        // objList = strList; 这里出错了，为什么
        //主要是为了保证泛型的有效性，如果可以操作成功，
        //objList.add(new Date());
        //strList泛型明明是String,但是却放入了一个Date对象，这是不能容忍的
        Collection<Object> coll = null;
        ArrayList<Object> list = null;
        coll = list;

    }

}
