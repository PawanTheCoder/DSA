package MonotonicStack;

import java.util.Stack;

public class Leetcode582 {
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,3};
        int result = findUnsortedSubarray(nums);
        System.out.println("Ans : " + result);
    }
    public static int findUnsortedSubarray(int[] nums) {
       int n = nums.length;
       int right = 0;
       int left = n;
       Stack<Integer> stack = new Stack<>();

       for(int i = 0 ; i < n ; i ++) {
        while(!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
            left  = Math.min(left , stack.pop());
        }
        stack.push(i);
       }

       stack.clear();

       for(int i = n -1 ; i >= 0 ; i --) {
        while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
            right = Math.max(right , stack.pop());
        }
        stack.push(i);
       }

       return right > left ? right - left + 1 : 0;
    }
}
