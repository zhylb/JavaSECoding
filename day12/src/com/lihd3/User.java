package com.lihd3;

import java.util.Optional;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/18 22:13
 */
public class User {
    private Address address;
    private String email;
    private String password;
    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }

    @Override
    public String toString() {
        return "User{" +
                "address=" + address +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
