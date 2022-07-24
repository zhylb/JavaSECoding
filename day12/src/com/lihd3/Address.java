package com.lihd3;

import java.util.Optional;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/18 22:11
 */
public class Address {

    private Country country;
    private int id;

    public Address(Country country, int id) {
        this.country = country;
        this.id = id;
    }

    public Address() {
    }

    public Optional<Country> getCountry() {
        return Optional.ofNullable(country);
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country=" + country +
                ", id=" + id +
                '}';
    }
}
