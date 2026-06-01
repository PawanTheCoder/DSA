package StackDS;

import java.util.Stack;
import java.util.Arrays;

public class Leetcode316 {
    public static void main(String[] args) {
        String s = "bcabc";
        String ans = removeDuplicateLetters(s);
        System.out.println(ans);
    }

    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();

        int[] freq = new int[26];
        boolean[] inStack = new boolean[26];
        Arrays.fill(inStack , false);
        for(char c : s.toCharArray()) {
            freq[c - 'a'] ++;
        }

        for(char c : s.toCharArray()) {
            freq[c - 'a'] --;

            if(inStack[c -'a']) {
                continue;
            }

            while(!stack.isEmpty() && stack.peek() > c && freq[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() -'a'] = false;
            }

            stack.push(c);
            inStack[c -'a'] = true;
        }

        StringBuilder ansStr = new StringBuilder();

        for(char c : stack) {
            ansStr.append(c);
        }

        return ansStr.toString();
    }
}
