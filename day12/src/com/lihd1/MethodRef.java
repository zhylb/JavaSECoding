package com.lihd1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.*;

/**
 *
 *  对象::实例方法名
 *  类::静态方法名
 *  类::实例方法名
 *  类::new;      -> 构造器引用
 *  Array[]::new; -> 数组引用
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/18 15:21
 */
public class MethodRef {

    /**
     * Test01 : 对象 :: 非静态方法
     * 实现接口的抽象方法的参数列表和返回值类型，必须与方法引用的
     * 方法的参数列表和返回值类型保持一致！
     */
    @Test
    public void test01 (){
        Person person = new Person("香菱", "璃月", "火", 4, "锅巴");

        // Consumer : void accept(T t)
        // Person   : void setName(String name)
        Consumer<String> con = person::setName;
        con.accept("四星之神");
        System.out.println(person);


        // Supplier : T    get()
        // Person : String getCountry()
        Supplier<String> sup = person::getCountry;
        String s = sup.get();
        System.out.println(s);

        // Function : R apply(T)
        // Person  : int CompareTo(Person p)
        Function<Person,Integer> func = person::compareTo;
        Integer apply = func.apply(new Person());
        System.out.println(apply);

    }

    /**
     * Test02 : 类 :: 静态方法
     * 实现接口的抽象方法的参数列表和返回值类型，必须与方法引用的
     * 方法的参数列表和返回值类型保持一致！
     */
    @Test
    public void test02 (){
        //Comparator : int compareTo(int,int)
        //Integer : int compareTo(int,int)
        Comparator<Integer> com = Integer::compareTo;

        //Supplier : T get()
        //Person   : ArrayList<Person> getList()
        Supplier<ArrayList<Person>> sup = Person::getList;
        for (Person person : sup.get()) {
            System.out.println(person);
        }

    }

    /**
     * Test03 : 类 :: 非静态方法
     *
     * 函数式接口方法
     * 要引用的方法
     * 满足 函数式接口方法的第一个参数是要引用方法的调用者，忽略第一个参数后两个方法的形参列表和返回值类型均相同即可
     * 下面说的参数是指将函数式接口第一个参数删去后的情况
     *
     */
    @Test
    public void test03 (){
        Person person = Person.getList().get(0);
        //Comparator : int compareTo(T t,T t)
        //Person :     int this.compareTo(Person p)
        //将T设置为Person后，两者的参数都为 （Person p）,返回值是 int
        Comparator<Person> com = Person::compareTo;

        //Function : R apply(T t)
        //Person :  String this.getName()
        //将T设置为Person后，两者的参数都为（），R设置为String,返回值都是String
        Function<Person,String > func = Person::getName;
        String apply = func.apply(person);
        System.out.println(apply);


        //BiConsumer : void accept(T,R)
        //Person :    void this.setName(String)
        //将T设置为Person,R设置为String两者的参数都是 (String)，返回值都是 void
        BiConsumer<Person,String > biCons = Person::setName;
        biCons.accept(person,"落魄了家人们");
        System.out.println(person);

    }

    /**
     * Test04 : 构造器引用
     * 函数式接口与构造器形参列表形同，返回值相同
     * 构造器的返回值就是构造器类对象
     *
     */
    @Test
    public void test04 (){
        //Supplier : T get()
        //Person : Person()
        Supplier<Person> sup = Person::new;

        //BiFunction : R get(T, U);
        //Person :    Person(String,String);
        BiFunction<String,String ,Person> func = Person::new;
        Person apply = func.apply("达达利亚", "至冬");
        System.out.println(apply);
    }

    /**
     * Test05 : 数组引用
     * 将 new int[] 其中的 int[]看做为一种特殊的构造器即可
     * 函数式接口与构造器形参列表形同，返回值相同
     * 构造器的返回值就是构造器类对象
     * 简便记忆 ：右边直接写 Xxx[]::new;即可
     *
     */
    @Test
    public void test05 (){

        //Function :  R  apply(T t)
        //String   : String[] String[length]
        Function<Integer,String[]> func = String[]::new;//数组里面不要写长度哦，就像上面的构造器引用一样不用写参数

        for (String s : func.apply(5)) {
            System.out.println(s);
        }


    }


}
