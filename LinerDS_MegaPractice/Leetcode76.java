package LinerDS_MegaPractice;

import java.util.HashMap;

public class Leetcode76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));

    }
    public static String minWindow(String s, String t) {
        int[] need = new int[128];
        int[] window = new int[128];

        for(char c : t.toCharArray()) {
            need[c]++;
        }

        int required = 0;

        for(int x : need) {
            if(x >0) required++;
        }

        int formed = 0;
        int bestStart =0;
        int bestLen = Integer.MAX_VALUE;
        int left=0;
        for(int right =0; right <s.length();right ++) {
            char c = s.charAt(right);
            window[c]++;
            if(need[c] >0 && window[c] == need[c]) {
                formed ++;
            }

            while(formed == required) {
                if(bestLen > right - left + 1) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }
                char remove = s.charAt(left);
                window[remove]--;

                if(need[remove] > 0 && window[remove] < need[remove]) {
                    formed--;
                }
                left ++;
            }
        }
        return s.substring(bestStart , bestStart + bestLen);
    }
}