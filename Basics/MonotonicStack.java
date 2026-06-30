package Basics;

import java.util.Stack;

public class MonotonicStack {
    public static void main(String[] args) {
        int[] nums = { 3,1,4,2};
        Stack<Integer> stack = new Stack<>();
        for(int num : nums) {
            System.out.println(stack);
            while(!stack.isEmpty() && stack.peek() > num) {
                if(stack.size() == 2) {
                System.out.println("Success");
            }
             stack.pop();
            }
            stack.push(num);
        }
    }
}
