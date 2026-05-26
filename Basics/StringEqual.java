package Basics;

import java.util.Stack;

public class StringEqual {
    public static void main(String[] args) {
        String s = "xywrrmp";
        String t = "xywrrmu#p";
        
        System.out.println(solution(s , t));
    }

    public static boolean solution(String s , String t) {
         Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '#' && stack1.isEmpty() == false) {
                stack1.pop();
            }else {
                stack1.push(c);
            }
        }

        for(char c : t.toCharArray()) {
            if(c == '#' && stack2.isEmpty() == false) {
                stack2.pop();
            }else {
                stack2.push(c);
            }
        }
        if(stack1.size() != stack2.size());
            while(!stack1.isEmpty()) {
                if(stack1.pop() != stack2.pop()) {
                    return false;
                }
            }
        return true;
    }
}
