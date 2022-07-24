package com.lihd3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理 还是感觉有一点抽象
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/17 21:17
 */
public class ProxyFactory {

    public static Object getProxyInstance(Object obj){
        Class<?> clazz = obj.getClass();
        ClassLoader loader = clazz.getClassLoader();
        Class<?>[] interfaces = clazz.getInterfaces();
        MyInvocationHandler handler = new MyInvocationHandler(obj);
        Object o = Proxy.newProxyInstance(loader, interfaces, handler);
        return o;
    }


}

class MyInvocationHandler implements InvocationHandler {
    Object obj;
    MyInvocationHandler(Object obj){
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("准备工作");
        Object invoke = method.invoke(obj, args);
        System.out.println("结束工作");
        return invoke;
    }
}
