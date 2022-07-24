package com.lihd2;

/**
 * 封装性
 *  我们程序设计追求“高内聚，低耦合”。
 *       高内聚 ：类的内部数据操作细节自己完成，不允许外部干涉；
 *       低耦合 ： 仅对外暴露少量的方法用于使用。
 *  隐藏对象内部的复杂性，只对外公开简单的接口。便于外界调用，从而提高系统的可扩展性、可维护性。
 *      通俗的说， 把该隐藏的隐藏起来，该暴露的暴露出来。 这就是封装性的设计思想。
 *
 * 问题引入
 *      当我们创建一个类的对象以后，我们可以通过"对象.属性"的方式，对对象的属性进行赋值。
 *      这里，赋值操作要受到属性的数据类型和存储范围的制约。除此之外，没其他制约条件。
 *      但是，在实际问题中，我们往往需要给属性赋值加入额外的限制条件。这个条件就不能在属性声明时体现，
 *      我们只能通过方法进行限制条件的添加。（比如：setLegs()
 *      同时，我们需要避免用户再使用"对象.属性"的方式对属性进行赋值。则需要将属性声明为私有的(private).
 *      -->此时，针对于属性就体现了封装性。
 * 封装性的体现
 *      1 私有化属性 提供公共的get和set方法
 *      2 私有化不对外暴露的方法
 *      3 单例模式
 *      4 缺省的类,外面的包无法调用
 * 四种权限修饰符
 *      1 private < 缺省 < protected < public
 *      2 可以修饰 : 属性 方法 构造器 内部类
 *      3 修饰类只能使用 缺省 和 public
 *
 * get方法就是get, set就是set做好自己的功能 不要设计奇怪的方法
 *
 * 可以理解缺省是为了包而设计 缺省的类,缺省的属性 在包外无法访问
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/9 19:12
 */
public class AnimalTest {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.setAge(100);
        System.out.println(a.getAge());
    }
}

class Animal{
    private int age;
    private String name;

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
