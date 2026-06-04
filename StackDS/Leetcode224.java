package StackDS;

import java.util.Stack;

public class Leetcode224 {
    public static void main(String[] args) {
        String s = "1 - ( 5 - 2)";
        int ans = calculate(s);
        System.out.println(ans);
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1; // +1 or -1

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // sign
                result += stack.pop(); // previous result
            }
        }
        result += sign * number;
        return result;
    }
}
