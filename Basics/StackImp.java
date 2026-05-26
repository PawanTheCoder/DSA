package Basics;

import java.util.Stack;

public class StackImp {
    public static void main(String[] args) {
        String str1 = "[[]])";

        if(validString(str1)) {
            System.out.println("String " + str1 + " Is Accepted");
        }else {
            System.out.println("String " + str1 + " Is not Accepted");
        }
    }

    public static boolean validString(String str1){
        Stack<Character> stack = new Stack<>();

        for(char ch : str1.toCharArray()) {

            // Opening Braces
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            // closing )
            else if(ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }

            // closing }
            else if(ch == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }

            // closing ]
            else if(ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
        }

        // Valid only if stack is empty
        return true;
    }
}
