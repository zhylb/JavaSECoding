package com.lihd1;

import java.lang.annotation.*;

/**
 * 自定义注解 ：建议参考 注解suppressWarning<br>
 * 1 定义方式 ： public @interface xxx{/** },其中 @interface只是一个用来定义Annotation的符号，与接口没有任何关系<br>
 * 2 父类 ：java.lang.annotation.Annotation
 * 3 成员变量 ：在 Annotation 定义中以无参数方法的形式来声明。 其方法名和返回值定义了该成员的名字和类型。 我们称为配置参数。<br>
 *      类型只能是八种基本数据类型、 String类型、 Class类型、 enum类型、 Annotation类型、以上所有类型的数组<br>
 * 4 初始值 ：成员变量的初始值使用default定义
 * 5 注意 ：如果只有一个成员值，建议使用value这个名字
 * 6 注意 ：如果定义的注解含有配置参数， 那么使用时必须指定参数值， 除非它有默认值。 格式是“参数名 = 参数值” ， 如果只有一个参数成员，
 *          且名称为value，可以省略“value=”，这也是5建议的原因
 * 7 没有成员定义的 Annotation 称为标记; 包含成员变量的 Annotation 称为元数据 Annotation
 *
 * ！ ： 自定义注解必须配上注解的信息处理流程才有意义。
 *
 *
 *
 * 元数据的理解 ：String name = "love",其中love是数据，而String name都是用来修饰说明love的元数据
 * JDK5.0提供了4个标准的meta-annotation 元注解 类型， 分别是：
 * Retention ：指明生命周期  RetentionPolicy枚举类中对象
 *          SOURCE 只在源文件中保存
 *          CLASS 默认行为 class文件中存在，运行时不存在
 *          RUNTIME 运行时存在, 如果要反射获取，应当使用
 * Target ：定义能够修饰说明元素 ElementType枚举类中的对象
 *          TYPE ：类，接口，枚举类，注解
 *          FIELD ：属性
 *          METHOD : 方法
 *          PARAMETER ：参数
 * Documented ：注解可以被javadoc提取，比如SuppressWarning
 *          一般不会被提取
 *          定义为Documented的注解必须设置Retention值为RUNTIME
 * Inherited ：被它修饰的 Annotation 将具有继承性。如果某个类使用了被
 *          Inherited 修饰的 Annotation, 则其子类将自动具有该注解
 *          很少使用
 *
 *
 */
@Inherited
@Documented
@Repeatable(MyAnnotations.class)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    // String value();
    String value() default "tmd";

}
