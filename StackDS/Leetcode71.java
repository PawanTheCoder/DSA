package StackDS;

import java.util.Stack;

public class Leetcode71 {
    public static void main(String[] args) {
        String s = "/home/user/Documents/../Pictures";
        String ans = simplifyPath(s);
        System.out.println(ans);
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for(String part : parts) {
            if(part.equals("") || part.equals(".")) {
                continue; // Skip empty or current directory
            } else if(part.equals("..")) {
                if(!stack.isEmpty()) stack.pop(); // go back one dir
            }else {
                stack.push(part); // valid dir
            }
        }

        StringBuilder result = new StringBuilder();
        for(String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }
}
