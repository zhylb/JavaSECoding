package com.lihd1;

import java.util.ArrayList;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/18 15:11
 */
public class Person implements Comparable<Person>{

    public static ArrayList<Person> getList(){
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("迪卢克","蒙德","火",5,"暗夜英雄",1.5));
        list.add(new Person("钟离","璃月","岩",5,"尘世闲游",180.0));
        list.add(new Person("班尼特","蒙德","火",4,"小倒霉蛋",90));
        list.add(new Person("枫原万叶","稻妻","风",5,"万叶之一刀",100));
        list.add(new Person("达达利亚","至冬","水",5,"烧冻鸡翅",300));
        list.add(new Person("神里绫华","稻妻","冰",5,"神里绫华参见",130));
        list.add(new Person("雷电将军","稻妻","雷",5,"无想一刀",69));
        list.add(new Person("行秋","璃月","水",4,"裁雨留虹",63));
        list.add(new Person("刻晴","璃月","雷",5,"斩尽牛杂",800));
        list.add(new Person("莫娜","蒙德","水",5,"摩拉",200));
        return list;
    }

    private String name;
    private String country;
    private String element;
    private int stars;
    private String desc;
    private double price;

    public Person() {
    }

    public Person(String name, String country, String element, int stars, String desc) {
        this.name = name;
        this.country = country;
        this.element = element;
        this.stars = stars;
        this.desc = desc;
    }

    public Person(String name, String country, String element, int stars, String desc, double price) {
        this.name = name;
        this.country = country;
        this.element = element;
        this.stars = stars;
        this.desc = desc;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (stars != person.stars) return false;
        if (Double.compare(person.price, price) != 0) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (country != null ? !country.equals(person.country) : person.country != null) return false;
        if (element != null ? !element.equals(person.element) : person.element != null) return false;
        return desc != null ? desc.equals(person.desc) : person.desc == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (element != null ? element.hashCode() : 0);
        result = 31 * result + stars;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", element='" + element + '\'' +
                ", stars=" + stars +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return -Double.compare(this.getPrice(),o.getPrice());
    }
}
