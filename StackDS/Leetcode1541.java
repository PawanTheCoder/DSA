package StackDS;

import java.util.Stack;

public class Leetcode1541 {
    public static void main(String[] args) {
        String s = "((())))))";
        System.out.println(minInsertions(s));
    }

    public static int minInsertions(String s) {
        int totalInsertions = 0;
        Stack<Character> stack = new Stack<>();
        int opened = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
                opened ++;
            }else if(!stack.isEmpty() && c == ')' && stack.peek() == ')' && opened > 0) {
                stack.pop();
                stack.pop();
                opened --;
            }else {
                stack.push(c);
            }
        }
        for(char num : stack) {
            System.out.print(num + " ");
        }
        int closed = 0;
        while(!stack.isEmpty()) {
            char c = stack.pop();
            if(c == ')' && closed == 0) {
                closed =1 ;
                totalInsertions += 2;
            }else if(c == ')' && closed == 1) {
                totalInsertions -= 1;
                closed = 0;
            }else if(c == '(' && closed == 1) {
                totalInsertions -=1;
            }else {
                totalInsertions += 2;
                closed = 0;
            }
            System.out.println(totalInsertions + " ");
        }
        return totalInsertions;
    }
}
