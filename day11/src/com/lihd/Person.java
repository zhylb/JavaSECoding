package com.lihd;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/17 9:28
 */
public class Person {
    public int intPublic;
    int intDefault;
    protected int intProtected;
    private int intPrivate;

    public Person(){

    }

    public Person(int intPublic){
        this.intPublic = intPublic;
    }

    private Person(int intPublic,int intPrivate){
        this.intPublic = intPublic;
        this.intPrivate = intPrivate;
    }


    public void methodPublic(){
        System.out.println("methodPublic");
    }

    private int methodPrivate(int a){
        System.out.println("methodPrivate");
        return a * a;
    }

    @Override
    public String toString() {
        return "Person{" +
                "intPublic=" + intPublic +
                ", intDefault=" + intDefault +
                ", intProtected=" + intProtected +
                ", intPrivate=" + intPrivate +
                '}';
    }
}
