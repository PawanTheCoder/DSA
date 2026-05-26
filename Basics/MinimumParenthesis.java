package Basics;

import java.util.Stack;

public class MinimumParenthesis {

    public static void main(String[] args) {
        String s = "()))((";
        System.out.println(valid(s));
    }
    public static int valid(String s) {
        Stack<Character> stack = new Stack<>();
        int open = 0;
        for(char c : s.toCharArray()) {
            if(c == ')' && open == 0) stack.push(c);
            if(c == '(') {
                stack.push(c);
                open ++;
            }
            if(c == ')' && open >0)  {
                stack.pop();
                open --;
            }
        }
        return stack.size();
    }   
}
