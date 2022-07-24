package com.lihd.part01;

/**
 * 输入一个字符串数组words，详情见p10
 * 启发 ：二进制与布尔型数组 可以互相转换
 *
 *
 *
 *
 */
public class Part05_单词长度的最大乘积 {

    public static void main(String[] args) {
        String[] words = {"abcw","foo","bar","fwxyz","abcdef"};
        int maxProduct = maxProduct(words);
        int maxProduct1 = maxProduct1(words);
        System.out.println("maxProduct = " + maxProduct);
        System.out.println("maxProduct1 = " + maxProduct1);
    }


    public static int maxProduct1(String[] words){
        boolean[][] flags = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                flags[i][ch - 'a'] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int k = 0;
                for (k = 0; k < 26; k++) {
                    if(flags[i][k] && flags[j][k]){
                        break;
                    }
                }
                if(k == 26){
                    int mul = words[i].length() * words[j].length();
                    result = Math.max(mul,result);
                }
            }
        }

        return result;
    }


    public static int maxProduct(String[] words){
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                flags[i] |= 1 << ch - 'a';
            }
        }
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if((flags[i] & flags[j]) == 0){
                    int mut = words[i].length() * words[j].length();
                    result = Math.max(mut,result);
                }
            }
        }
        return result;
    }
}
