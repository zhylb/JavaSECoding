package com.lihd4;

/**
 * 自己重写 equals 与 toString
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/11/18 23:13
 */
public class User {
    private String name;
    private int age;


//    public boolean equals(Object o){
//        if(o == null) return false;
//        if(o == this) return true;
//        if(!(o instanceof User)) return false;
//        User u = (User) o;
//        if(u.getAge() != getAge()) return false;
//        if(u.getName().equals(getName())) return true;
//        return false;
//    }
//
//    public String  toString(){
//        return "User[ name = " + name + ", age = " + age + "]";
//    }

    //自动生成的 感觉真不错
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    public  User(){

    }

    public  User(int age){
        this.age = age;
    }

    public  User(String name, int age){
        this(age);
        this.name = name;
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
