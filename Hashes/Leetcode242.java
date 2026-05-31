package Hashes;

import java.util.*;

public class Leetcode242 {
    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";
        boolean ans = isAnagram(s, t);
        System.out.println(ans);
    }
    public static boolean isAnagram(String s, String t) {
        HashMap<Integer , Character> map = new HashMap<>();
        if(s.length() != t.length()) return false;
        for(int i =0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            map.put(i ,c );
        }

        for(int i = 0 ; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(map.containsValue(ch)) {
                map.remove(ch);
            }else {
                return false;
            }
        }
        System.out.println(map);
        return true;
    }
}
