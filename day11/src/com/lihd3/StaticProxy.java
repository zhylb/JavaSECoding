package com.lihd3;

/**
 * 静态代理
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/17 21:13
 */
public class StaticProxy {
    public static void main(String[] args) {
        PhoneFactory phoneFactory = new IPhoneFactory();
        IPhoneProxy iPhoneProxy = new IPhoneProxy(phoneFactory);
        iPhoneProxy.producePhone();
    }

}

class IPhoneProxy implements PhoneFactory{
    private PhoneFactory phoneFactory;
    IPhoneProxy(PhoneFactory phoneFactory){
        this.phoneFactory = phoneFactory;
    }

    @Override
    public void producePhone() {
        System.out.println("准备工作");
        phoneFactory.producePhone();
        System.out.println("结束工作");
    }
}
