package com.lihd1;

import java.util.Arrays;

/**
 * 注解 ：<p>元数据 jdk5新增</p>
 * 1 Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。<br>
 * 2 Annotation 可以像修饰符一样被使用, 可用于修饰包,类, 构造器, 方法, 成员变量, 参数, 局部变量的声明, 这些信息被保存在 Annotation<br>
 *      的 “name=value” 对中。<br>
 * 3 在JavaEE/Android中注解占据了更重要的角色，例如用来配置应用程序的任何切面， 代替JavaEE旧版中所遗留的繁冗代码和XML配置等<br>
 * 4 未来的开发模式都是基于注解的， JPA是基于注解的， Spring2.5以上都是基于注解的，注解是一种趋势，一定程度上<br>
 *      可以说： 框架 = 注解 + 反射 + 设计模式。<br>
 *
 * 使用Annotation 的实例
 * 1 生成文档注释
 * 2 编译时进行文档检查 （jdk内置三个）
 *      1 @Override 实现或继承
 *      2 @Deprecated 过时
 *      3 @SuppressWarning 抑制编译器检查
 * 3 跟踪代码依赖性，实现替代配置文件功能
 *
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/11 20:27
 */
public class AnnotationTest {
    @SuppressWarnings({"unused","rowtypes"})
    int[] arr = new int[5];

    @Override
    public String toString() {
        return "AnnotationTest{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
    @Deprecated
    public void show(){

    }


}
