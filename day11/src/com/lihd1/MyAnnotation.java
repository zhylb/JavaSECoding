package com.lihd1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE_USE,ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME) //一定要改成runtime否则无法获取
public @interface MyAnnotation {
    String value() default "login";
}
