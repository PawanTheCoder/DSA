package SlidingWindow.FrequencyCount;

import java.util.Arrays;

public class Leetcode567 {
    public static void main(String[] args) {
        String s1 = "cda";
        String s2 = "dadc";
        boolean ans = checkInclusion(s1, s2);
        System.out.println(ans);
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] need = new int[26];
        int[] window = new int[26];

        // Store the frequency of s1 into need
        for(char c : s1.toCharArray()) {
            need[c - 'a'] ++;
        }

        // Make first window
        for(int i =0 ; i < s1.length(); i++) {
            char c = s2.charAt(i);
            window[c - 'a']++;
        }

        // Edge Case (If the first window is permutation :)
        if(Arrays.equals(window , need)) {
            return true;
        }

        // Slding Window :
        for(int right = s1.length() ; right < s2.length(); right++) {
            // Add Incodimg element to window
            window[s2.charAt(right) - 'a']++;

            // Remove the element which is going to left the window
            window[s2.charAt(right -s1.length()) - 'a']--;

            if(Arrays.equals(window, need)) return true;
        }
        return false;
    }
}
