package com.lihd;

/**
 * jdk5中如何自定义枚举类
 *      0 使用enum关键字定义枚举类
 *      1 写出所有对象，对象之间中 ","隔开  末尾用 ";" 省略private final等很多内容
 *      2 写出属性名，省略private final
 *      3 写出构造器，省略private
 *
 * 枚举类的父类 ：java.lang.Enum
 * public abstract class Enum<E extends Enum<E>>
 *         implements Constable, Comparable<E>, Serializable {
 *
 * 枚举类需要注意的地方 ：可以放在switch中
 *
 * 枚举类Enum常用的三个方法
 *      1 static values() 返回所有对象的数组
 *      2 static valueOf(String) 根据String传入的名字返回指定的对象，可能报错
 *      3 toString() 打印对象，只打印名称
 *
 * 枚举类实现接口
 *      1 统一实现 （不在演示）
 *      2 每个对象实现
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/10 15:17
 */
public class EnumTest {

    public static void main(String[] args) {
        Season spring = Season.SPRING;

        //1个小注意 ： 可以放到switch中
        switch (spring){
            case SPRING -> System.out.println("1");
            case SUMMER -> System.out.println("2");
            case AUTUMN -> System.out.println("3");
            case WINTER -> System.out.println("4");
        }

        //第一个方法 values()
        Season[] values = Season.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        //第二个方法 valueOf()
        Season valueOf = Season.valueOf("SPRING");
        System.out.println(valueOf);


        //第三个方法 toString
        System.out.println(spring);

        //
        spring.show();
    }

}


interface Show{
    void show();
}

enum Season implements Show{
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天真好");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天真好");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天真好");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("冬天真好");
        }
    };

    String name;
    String desc;

    Season(String name,String desc){
        this.name = name;
        this.desc = desc;
    }
}