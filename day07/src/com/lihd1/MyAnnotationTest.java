package com.lihd1;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/11 21:19
 */
public class MyAnnotationTest {
    public static void main(String[] @MyAnnotation args) throws @MyAnnotation Exception {
        Class<Son> aClass = Son.class;
        Annotation[] annotations = aClass.getAnnotations();
        //@com.lihd1.MyAnnotation("tmd")
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //*******************************************
        int[] @MyAnnotation arr = new @MyAnnotation int[5];
        int b = (@MyAnnotation int)78L;

        @MyAnnotation HashMap<@MyAnnotation Integer,@MyAnnotation String> map = new HashMap<>();
        for (Map.Entry<@MyAnnotation Integer, String> integerStringEntry : map.entrySet()) {

        }


    }
}

@MyAnnotation
@MyAnnotation
@MyAnnotation
//@MyAnnotations({@MyAnnotation,@MyAnnotation("hello")}) java8之前的写法
class Father{
    @MyAnnotation(value = "年龄")
    int age;

    int show(@MyAnnotation int a){
        return a;
    }
}

class Son<@MyAnnotation Object> extends Father{

    @MyAnnotation("hello")
    @Override
    int show(int a) {
        return super.show(a);
    }
}