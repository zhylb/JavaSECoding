package com.lihd3;

/**
 * 动态代理测试
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/17 21:23
 */
public class ProxyFactoryTest {
    public static void main(String[] args) {
        PhoneFactory phoneFactory = new IPhoneFactory();
        PhoneFactory proxyInstance = (PhoneFactory) ProxyFactory.getProxyInstance(phoneFactory);
        proxyInstance.producePhone();
    }

}
