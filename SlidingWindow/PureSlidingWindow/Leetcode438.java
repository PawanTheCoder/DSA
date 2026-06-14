package SlidingWindow.PureSlidingWindow;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Leetcode438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> ans = findAnagrams(s, p);
        System.out.println((ans));
    }

    public static List<Integer> findAnagrams(String s, String p) {
       List<Integer> indices = new ArrayList<>();
       int left =0;
       int right =0;
       int window = p.length();
       HashMap<Character , Integer> copyMap = new HashMap<>();
       HashMap<Character , Integer> set = new HashMap<>();
       for(char c : p.toCharArray()) {
        set.put(c , 0);
        copyMap.put(c , 0);
       }

       while(right < s.length()) {
        char c = s.charAt(right);
        int currentWindow = right -left + 1;
        if(currentWindow <=window && set.containsKey(c)) {
            right++;
            set.remove(c);
            System.out.println(set);
        }if(currentWindow == window && set.isEmpty()) {
            System.out.println("Yes");
            if(right < s.length() - 1) {
                indices.add(left);
                right ++;
                left = right;
                set = new HashMap<>(copyMap);
            }else {
                break;
            }
                
        }if(!copyMap.containsKey(c)) {
            System.out.println("Not in anagram");
            if(right < s.length() - 1) {
                right++;
                left = right;
            }else {
                break;
            }
        }if(!set.containsKey(c)) {
            System.out.println("Duplicate");
            left++;
            right++;
            if(left == s.length()) {
                break;
            }
        }
       }
       return indices;
    }
}
