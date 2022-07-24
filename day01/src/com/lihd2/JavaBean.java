package com.lihd2;

/**
 * JavaBean是一种Java语言写成的可重用组件。
 *
 * 所谓javaBean，是指符合如下标准的Java类：
 *      类是公共的
 *      有一个无参的公共的构造器
 *      有属性，且有对应的get、 set方法
 *
 *  用户可以使用JavaBean将功能、处理、值、数据库访问和其他任何可以
 * 用Java代码创造的对象进行打包，并且其他的开发者可以通过内部的JSP
 * 页面、 Servlet、其他JavaBean、 applet程序或者应用来使用这些对象。用
 * 户可以认为JavaBean提供了一种随时随地的复制和粘贴的功能，而不用关
 * 心任何改变。
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/9 21:36
 */
public class JavaBean {
    private int age;
    private String name;

    public JavaBean() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
