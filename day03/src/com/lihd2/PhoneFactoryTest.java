package com.lihd2;

/**
 * 简单使用了反射
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/20 16:17
 */
public class PhoneFactoryTest {

    public static void main(String[] args) throws Exception{
        Phone mi = PhoneFactory.getPhone("Mi");
        mi.call();

        Phone iphone = PhoneFactory.getPhone("IPhone");
        iphone.call();

        Phone huawei = PhoneFactory.getPhone("Huawei");
        huawei.call();

    }


}

interface Phone{
    void call();
}

class PhoneFactory implements Phone{


    public static Phone getPhone(String name) throws Exception{
        name = "com.lihd2."+name;

        Class<?> phone = Class.forName(name);

        Object o = phone.newInstance();

        return (Phone) o;
    }

    @Override
    public void call() {

    }
}

class Mi implements Phone{

    @Override
    public void call() {
        System.out.println("小米");
    }
}

class IPhone implements Phone{

    @Override
    public void call() {
        System.out.println("苹果");
    }
}

class Huawei implements Phone{
    @Override
    public void call() {
        System.out.println("华为");
    }
}