package com.lihd2;

import com.lihd1.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/18 19:24
 */
public class StreamTest1 {


    public static Stream<Character> strToCharaStream(String s){
        ArrayList<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    /**
     * Test01 :
     * filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
     * distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
     * limit(long maxSize) 截断流，使其元素不超过给定数量
     * skip(long n) 跳过元素，返回一个扔掉了前 个空流。与 limit(n) 互补 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
     *
     *
     */
    @Test
    public void test01 (){
        //1 filter 找到持有火元素的角色
        Person.getList().stream().filter(s -> "火".equals(s.getElement())).forEach(System.out::println);
        System.out.println("---------------------------------------");
        //2 limit
        Person.getList().stream().limit(3).forEach(System.out::println);
        System.out.println("---------------------------------------");
        //3 skip
        Person.getList().stream().skip(3).forEach(System.out::println);
        System.out.println("---------------------------------------");
        //4 distinct()
        ArrayList<Person> list = Person.getList();
        list.add(new Person("刻晴1","璃月","雷",5,"斩尽牛杂",800));
        list.add(new Person("刻晴1","璃月","雷",5,"斩尽牛杂",800));
        list.add(new Person("刻晴1","璃月","雷",5,"斩尽牛杂",800));
        list.stream().distinct().forEach(System.out::println);
    }


    /**
     * Test02 :
     * map(Function f)接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * mapToDouble(ToDoubleFunction f)接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 DoubleStream。
     * mapToInt(ToIntFunction f)接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 IntStream。
     * mapToLong(ToLongFunction f)接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 LongStream。
     * flatMap(Function f)接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     *
     *
     */
    @Test
    public void test02 (){
        //1 输出所有名字长度大于3的名字
        Person.getList().stream().map(Person::getName).filter(s -> s.length() > 3).forEach(System.out::println);
        //2 输出所有价格大于200的价格
        Person.getList().stream().mapToDouble(Person::getPrice).filter(p -> p > 200).forEach(System.out::println);

        //3 体会flatMap（addAll）和 Map（add）的区别
        List<String> list = Arrays.asList("My", "Songs", "Know");

        list.stream().map(StreamTest1::strToCharaStream).forEach(s -> s.forEach(System.out::println));//add
        list.stream().flatMap(StreamTest1::strToCharaStream).forEach(System.out::println);//addAll
    }

    /**
     * Test03 : 排序
     * sorted() 产生一个新流，其中按自然顺序排序
     * sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
     */
    @Test
    public void test03 (){
        //Person.getList().stream().sorted().forEach(System.out::println);
        System.out.println("------------------------------------------");
        //Person.getList().stream().sorted((p1,p2) -> p1.getName().compareTo(p2.getName())).forEach(System.out::println);
        Person.getList().stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);

        //根据价格排序
        Person.getList().stream().sorted(Comparator.comparingDouble(Person::getPrice)).forEach(System.out::println);


    }

}
