package Basics;
import java.util.Stack;

public class MinParenth {
    public static void main(String[] args) {
        String s = "()(ui)((";
        System.out.println(minRemoveToMakeValid(s));
    } 
    
    public static String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        StringBuilder result = new StringBuilder();
        int open = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
                open ++;
                continue;
            }
            if(c == ')' && open > 0) {
                stack.push(c);
                open --;
                continue;
            } 
            if(c == ')' && open == 0) {
                continue;
            }
            stack.push(c);
        }

        for (int i = stack.size() - 1; i >= 0; i--) {
            if(stack.get(i) == '(' && open > 0) {
                open --;
                continue;
            }else {
                result.append(stack.get(i));
            }
       }

        return result.reverse().toString();
    }
}

