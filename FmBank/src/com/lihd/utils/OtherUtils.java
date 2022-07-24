package com.lihd.utils;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/12/29 22:24
 */
public class OtherUtils {
    public static double getDouble(String s){
        if(s.equals("")) return -1;
        try{
            double aDouble = Double.parseDouble(s);
            return aDouble;
        }catch (Exception e){
            return -1;
        }
    }
}
