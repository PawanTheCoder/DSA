package SlidingWindow.FrequencyCount;

import java.util.HashSet;

public class Leetcode3 {
    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left =0;
        int minLength = 1;
        HashSet<Character> set = new HashSet<>();

        for(int right=0;right < s.length();right++) {
            char c = s.charAt(right);

            if(set.contains(c)) {
                while(s.charAt(left) != c) {
                    set.remove(s.charAt(left));
                    left++;   
                }
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            minLength = Math.max(minLength , right-left + 1);
        }
        return minLength;
    }
}
