package StackDS;

import java.util.Stack;

public class Leetcode227 {
    public static void main(String[] args) {
        String s = "3 + 5 * 4 / 2";
        int ans = calculate(s);
        System.out.println(ans);
    }

    public static int calculate(String s) {
        int ans = 0;
        Stack<String> stack = new Stack<>();

        boolean isMul = false;
        boolean isdivide = false;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                continue;
            if (isMul) {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                String result = Integer.toString(num1 * num2);
                stack.push(result);
            } else if (isdivide) {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                String result = Integer.toString(num1 / num2);
                stack.push(result);
            }
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                StringBuilder operatorStr = new StringBuilder();
                stack.push(str.toString());
                str.setLength(0);
                if (c == '*') {
                    isMul = true;
                    continue;
                } else if (c == '/') {
                    isdivide = true;
                    continue;
                } else {
                    operatorStr.append(c);
                    stack.push(operatorStr.toString());
                    operatorStr.setLength(0);
                }
            }
            str.append(c);
        }

        if (isMul) {
            int num1 = Integer.parseInt(stack.pop());
            int num2 = Integer.parseInt(stack.pop());
            String result = Integer.toString(num1 * num2);
            stack.push(result);
        } else if (isdivide) {
            int num1 = Integer.parseInt(stack.pop());
            int num2 = Integer.parseInt(stack.pop());
            String result = Integer.toString(num1 / num2);
            stack.push(result);
        }

        for (String string : stack) {
            System.out.println(string);
        }

        while (stack.size() > 1) {
            int num1 = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            if (operator == "+") {
                int num2 = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(num1 + num2));
            } else if (operator == "-") {
                int num2 = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(num1 - num2));
            }
        }
        ans = Integer.parseInt(stack.pop());
        return ans;
    }
}
