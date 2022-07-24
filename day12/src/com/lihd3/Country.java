package com.lihd3;

import java.util.Optional;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/18 22:10
 */
public class Country {
    private String isocode;

    private String countryName;

    public Country() {
    }

    public Country(String isocode, String countryName) {
        this.isocode = isocode;
        this.countryName = countryName;
    }

    public Optional<String> getIsocode() {
        return Optional.ofNullable(isocode);
    }

    public void setIsocode(String isocode) {
        this.isocode = isocode;
    }

    @Override
    public String toString() {
        return "Country{" +
                "isocode='" + isocode + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
