package Basics;

import java.util.ArrayList;
import java.util.HashSet;

public class Leetcode3 {
    public static void main(String[] args) {
        String s = "pwwkew";
        int len = lengthOfLongestSubstring(s);
        System.out.println(len);

    }
    public static int lengthOfLongestSubstring(String s) {
        ArrayList<Character> arr = new ArrayList<>();
        int len = 0;
        int maxLen =0;
        for(int i =0 ; i < s.length() ;i++) {
            char c = s.charAt(i);
            for(int j = 0 ; j <arr.size(); j++) {
                if(c == arr.get(j)) {
                    for(int k = j ; k >= 0 ; k--) {
                        arr.remove(k);
                    }
                    maxLen = Math.max(maxLen , len);
                    len = arr.size();    
                }
            }
            len++;
            arr.add(c);
        }
        maxLen = Math.max(len , maxLen);
        return maxLen;
    }
}
