package MonotonicStack;

import java.util.Stack;

public class Leetcode503 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        int[] result = nextGreaterElement(nums);
        for(int i : result) {
            System.out.print(i + " ");
        }
        
    }

    public static int[] nextGreaterElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length ; i++) {
            result[i] = Integer.MIN_VALUE;
        }
        for(int i = 0 ; i < nums.length ; i++) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }

        for(int i = 0 ; i < result.length ; i++) {
            if(result[i] == Integer.MIN_VALUE) {
                for(int j = 0 ; j < i ; j++) {
                    if(nums[j] > nums[i]) {
                        result[i] = nums[j];
                        break;
                    }
                }
            }
        }

        for(int i = 0 ; i < result.length ; i++) {
            if(result[i] == Integer.MIN_VALUE) {
                result[i] = -1;
            }
        }
        return result;
    }
}
