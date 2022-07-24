package com.lihd1;

import java.lang.annotation.*;

/**
 * java1.8新增
 *
 * 可重复注解
 * 1 提供一个MyAnnotation
 * 2 提供MyAnnotations，并且属性为 MyAnnotation[] value();
 * 3 在MyAnnotation中 标记repeatable 即 Repeatable(MyAnnotations.class)
 * 4 要求 MyAnnotation 和 MyAnnotations上面的元注解建议一致，否则可能产生问题
 *
 * 类型注解 在@Target的枚举参数
 * 1 TYPE_PARAMETER 表示该注解可以声明在 类型变量的声明语句中，比如泛型
 * 2 TYPE_USE 表示可以修饰在任意地方 可以说几乎就是任何地方
 *
 */
@Inherited
@Documented
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)

public @interface MyAnnotations {

    MyAnnotation[] value();
}
