package com.lihd3;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/17 21:12
 */
public class IPhoneFactory implements PhoneFactory{
    @Override
    public void producePhone() {
        System.out.println("IPhoneFactory生产了一部苹果手机");
    }

}
