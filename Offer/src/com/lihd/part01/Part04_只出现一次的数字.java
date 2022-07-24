package com.lihd.part01;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/12 20:04
 */
public class Part04_只出现一次的数字 {

    public static void main(String[] args) {
//        int[] nums = {1,0,1,0,1,0,109};
//        int specialNum = specialNum(nums);
//        System.out.println("specialNum = " + specialNum);
        int[] nums = {1,0,1,0,1,0,109,109,109,109,109};
        int specialNum = specialNum(nums, 5, 3);
        System.out.println("specialNum = " + specialNum);
    }


    public static int specialNum(int[] nums){
        int[] bitNums = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitNums[i] += (num >> (31 - i)) & 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + bitNums[i] % 3;
        }


        return result;
    }

    public static int specialNum(int[] nums, int m, int n){
        int[] bitNums = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitNums[i] += (num >> (31 - i)) & 1;
            }
        }
        int result = 0;
        if(m > n){
            for (int i = 0; i < 32; i++) {
                int a = 0;
                if(bitNums[i] % n != 0) a = (bitNums[i] - n)/m;
                System.out.println(bitNums[i]);
                System.out.println(a);
                result = (result << 1) + (bitNums[i] % n)/m + a;
            }
        }else {
            for (int i = 0; i < 32; i++) {
                result = (result << 1) + (bitNums[i] % n) / m;
            }
        }
        return result;
    }
}
