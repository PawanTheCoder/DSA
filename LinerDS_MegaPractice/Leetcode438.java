package LinerDS_MegaPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Leetcode438 {
    public static void main(String[] args) {
        String s= "abacbabc";
        String p ="abc";
        List<Integer> ans = findAnagrams(s, p);
        System.out.println(ans);
        
    }
     public static List<Integer> findAnagrams(String s, String p) {
        HashMap<Character , Integer> map = new HashMap<>();
        HashMap<Character , Integer> comp = new HashMap<>();
        for(char c : p.toCharArray()) {
            map.put(c , map.getOrDefault(c, 0) + 1);
            comp.put(c , 0);
        }
        HashMap<Character , Integer> recovery = (HashMap<Character, Integer>) map.clone();
        System.out.println(recovery);
        List<Integer> index = new ArrayList<>();
        int left =0;
        for(int right =0; right < s.length(); right ++) {
            char c = s.charAt(right);
            if(right - left +1 > p.length()) {
                if(map.containsKey(s.charAt(left))) {
                   map.put( s.charAt(left)  , map.getOrDefault(s.charAt(left), 0) + 1);
                }
                left ++;
            }
            if(map.containsKey(right)) {
                map.put(c , map.get(c) -1);
                if(map.get(c) == -1) {
                    map.put(c , 0);
                    left = right;
                }
            }
            if(map.equals(comp)) {
                index.add(left);
            }
            
        }
        return index;
    }
}
