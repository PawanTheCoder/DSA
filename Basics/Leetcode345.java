package Basics;

import java.util.Arrays;

import java.util.HashSet;

public class Leetcode345 {
    public static void main(String[] args) {
        String s = "leetcode";

        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        HashSet<Character> map = new HashSet<>(Arrays.asList('a' , 'e' , 'i' , 'o' , 'u' , 'A' , 'E' , 'I' , 'O' ,'U'));
        int left =0;
        int right = s.length() - 1;
        while(left < right) {
            if(!map.contains(s.charAt(left))) {
                left ++;
                continue;
            }if(!map.contains(s.charAt(right))) {
                right --;
                continue;
            }
            char temp = s.charAt(left);
            str.setCharAt(left , s.charAt(right));
            str.setCharAt(right, temp);
            left ++;
            right--;
        }

        return str.toString();
    }
}