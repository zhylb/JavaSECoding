package com.lihd2;

import com.lihd1.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 规约
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/18 20:36
 */
public class StreamTest2 {
    /**
     * Test01 :
     * allMatch(Predicate p) 检查是否匹配所有元素
     * anyMatch(Predicate p) 检查是否至少匹配一个元素
     * noneMatch(Predicate p) 检查是否没有匹配所有元素
     * findFirst() 返回第一个元素
     * findAny() 返回当前流中的任意元素
     */
    @Test
    public void test01 (){
        Double d;
        //1 allMatch 寻找是否有 草元素
        boolean b = Person.getList().stream().map(Person::getElement).allMatch("草"::equals);
        System.out.println(b);//false
        //2 anyMatch 是否有价格大于500的
        boolean b1 = Person.getList().stream().map(Person::getPrice).anyMatch(a -> a > 500);
        System.out.println(b1);
        //3 noneMatch 是否有至冬国的人
        boolean b2 = Person.getList().stream().map(Person::getCountry).noneMatch("至冬"::equals);
        System.out.println(b2);//返回false 说明没有 至冬人的结果是假，因此list中有至冬国的人
        //4 findFirst 找到最贵的角色
        Optional<Person> first = Person.getList().stream().sorted().findFirst();
        System.out.println(first);
        //5 findAny 返回任何一个角色 - 这玩意好像返回的值是确定的
        Optional<Person> any = Person.getList().parallelStream().findAny();
        System.out.println(any);
    }

    /**
     * Test02 :
     * count() 返回流中元素总数
     * max(Comparator c) 返回流中最大值
     * min(Comparator c) 返回流中最小值
     * forEach(Consumer c)  内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反， Stream API 使用内部迭代——它帮你把迭代做了)
     */
    @Test
    public void test02 (){
        //1 count() 找到价格低于100的所有角色的个数
        long count = Person.getList().stream().map(Person::getPrice).filter(aDouble -> aDouble < 100).count();
        System.out.println(count);
        //2 max() 输出名字最大的对象
        Optional<Person> max = Person.getList().stream().max(Comparator.comparing(Person::getName));
        System.out.println(max);
        //3 min() 输出价格最低的对象
        Optional<Person> min = Person.getList().stream().min(Comparator.comparingDouble(Person::getPrice));
        System.out.println(min);
    }

    /**
     * Test03 :
     * reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
     * reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
     *
     *
     */
    @Test
    public void test03 (){
        //返回所有价格之和
        Optional<Double> reduce = Person.getList().stream().map(Person::getPrice).reduce(Double::sum);
        System.out.println(reduce);
    }

    /**
     * Test04 : collect(Collector c)
     * 将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
     *
     * Collectors中有以下属性提供调用
     * toList List<T> 把流中元素收集到List List<Employee> emps= list.stream().collect(Collectors.toList());
     * toSet Set<T> 把流中元素收集到Set Set<Employee> emps= list.stream().collect(Collectors.toSet());
     * toCollection Collection<T> 把流中元素收集到创建的集合Collection<Employee> emps =list.stream().collect(Collectors.toCollection(ArrayList::new));
     * counting Long 计算流中元素的个数
     * long count = list.stream().collect(Collectors.counting());
     * summingInt Integer 对流中元素的整数属性求和
     * int total=list.stream().collect(Collectors.summingInt(Employee::getSalary));
     * averagingInt Double 计算流中元素Integer属性的平均值
     * double avg = list.stream().collect(Collectors.averagingInt(Employee::getSalary));
     * summarizingInt IntSummaryStatistics 收集流中Integer属性的统计值。 如：平均值
     *
     *
     */
    @Test
    public void test04 (){
        //找到价格大于200的所有角色
        ArrayList<Person> collect = Person.getList().stream().filter(person -> person.getPrice() > 200).collect(Collectors.toCollection(ArrayList::new));
        //价格大于100角色价格的平均值
        Double collect1 = Person.getList().stream().filter(person -> person.getPrice() > 100).collect(Collectors.averagingDouble(Person::getPrice));
        System.out.println(collect1);
        //价格的最高的角色
        Optional<Person> collect2 = Person.getList().stream().collect(Collectors.maxBy(Comparator.comparingDouble(Person::getPrice)));
        System.out.println(collect2);

    }
}
