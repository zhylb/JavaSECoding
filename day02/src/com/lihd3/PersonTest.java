package com.lihd3;

/**
 * 多态
 * 1 可以理解为 一个事物的多种形态
 * 2 什么是多态 : 是对象的多态 : 父类引用指向子类对象(子类对象赋给父类引用)
 * 3 多态的前提 : 继承关系, 子类重写父类的方法
 * 4 多态的使用 : 虚拟方法调用
 *      编译时看左边, 运行时看右边
 *      有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，我们实际执行的是子类重写父类的方法
 * 5 注意 : 多态只适用于方法 不适用与属性
 *      对于属性,无论编译还是运行都是看左边
 *
 * 6 向下转型 : 使用强制类型转换符() 可能报错
 *      其中向上转型 称之为多态
 *      可以和 instanceof 搭配使用
 *      a instanceof A 结果为真 其中a是A类的对象
 *      a instanceof B 结果也为真 其中类B是类A 父类
 *      a instanceof java.lang.Object 为真
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/18 11:42
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.talk();
        p1.walk();
        p1.method();
        System.out.println(p1.id);
        System.out.println("-------------------------");
        Person p2 = new Man();
        p2.talk();
        p2.walk();
        p2.method();
        System.out.println(p1.id);
//        p2.earnMoney();

        System.out.println("-------------------------");
        Person p3 = new Woman();
        p3.walk();
        p3.talk();
        p3.method();
        System.out.println(p1.id);
//        p3.spendMoeny();

        System.out.println("------------------------------------------------");
        //下面是 向下转型 因为 p2本来就是Man new 的对象

        //建议先判断, 后强制转换
        if (p2 instanceof Man){
            Man m = (Man) p2;
            m.earnMoney();
        }



        System.out.println(p2 instanceof Man);//true
        System.out.println(p2 instanceof Woman);//false
        System.out.println(p2 instanceof Person);//true
        System.out.println(p2 instanceof Object);//true 这一条肯定为真








    }
}
