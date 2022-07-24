package com.java11.lihd;

import java.lang.annotation.*;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/19 21:57
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    // String value();
    String value() default "tmd";

}