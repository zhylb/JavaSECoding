package com.lihd1;

public interface MyInterface<T,K,V> {

    void inter();

    default void interDefault(){
        System.out.println("MyInterface::interDefault");
    }
}
