package com.lihd;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/8 8:38
 */
public class Hello {
    public static void main(String[] args) {
        String python = """
               原来你是这样的java，咱怎么也有三个引号了 
               你这新语法跟个python似的
               """;
        System.out.println(python);
        Day day = Day.LOVER;
        switch (day){
            case SPRING -> System.out.println("秋");
            case SUMMER -> System.out.println("秋");
            case AUTUMN -> System.out.println("秋");
            case WINTER -> System.out.println("秋");
            default -> System.out.println("老子没找到");
        }

    }
}

enum Day{
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER,
    LOVER;
}
