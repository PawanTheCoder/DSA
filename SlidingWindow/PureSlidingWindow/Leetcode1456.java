package SlidingWindow.PureSlidingWindow;

import java.util.HashSet;

public class Leetcode1456 {
    public static void main(String[] args) {
        String s = "leetcode";
        int k = 3;
        int ans = maxVowels(s, k);
        System.out.println(ans);
    }

    public static int maxVowels(String s, int k) {
        int left =0;
        int right =0;
        int maxNum = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int currentNum =0;
        while(right < s.length()) {
            if(set.contains(s.charAt(right))) {
                currentNum ++;
            }
            if(right - left + 1 <= k) {
                right++;
            }
            maxNum = Math.max(maxNum , currentNum);
            if(right - left + 1 > k) {
                if(set.contains(s.charAt(left))) {
                    currentNum --;
                }
                left ++;
            }
        }
        return maxNum;
    }
}
