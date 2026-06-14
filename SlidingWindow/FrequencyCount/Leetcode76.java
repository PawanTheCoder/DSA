package SlidingWindow.FrequencyCount;

import java.util.Arrays;
import java.util.HashMap;

public class Leetcode76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        int lock =0;
        HashMap<Character , Integer> map = new HashMap<>();
        int left =0;
        int right =0;
        int[] freq = new int[26];
        int[] copy = new int[26];
        int minLength = Integer.MAX_VALUE;
        int leftIndex = 0;
        int rightIndex =0;
        for(Character c : t.toCharArray()) {
            map.put(c ,map.getOrDefault(c, 0) + 1);
            freq[c - 'A'] ++;
        }

        while(right < s.length()) {
            if(Arrays.equals(freq , copy)) {
                if(right - left + 1 < minLength) {
                    leftIndex = left;
                    rightIndex = right;
                    if(map.containsKey(s.charAt(left))) {
                        freq[s.charAt(left) - 'A']++;
                    }
                    left++;
                    while(left < right && !map.containsKey(s.charAt(left))) {
                        left++;
                    }
                    lock =0;
                }
            }

            else if(map.containsKey(s.charAt(right)) && right < s.length()) {
                lock = 1;
                if(freq[s.charAt(right) - 'A'] > 0) {
                    freq[s.charAt(right) - 'A']--;
                }
            }
            else if(s.charAt(left) == s.charAt(right) && freq[s.charAt(right)- 'A'] == 0) {
                while(left < right && !map.containsKey(s.charAt(left))) 
                {
                    left++;
                }
            }
            
            if(right < s.length()) {
                right ++;
            }
            }
            System.out.println(leftIndex + " " + rightIndex + lock);
        return t;
    }
}