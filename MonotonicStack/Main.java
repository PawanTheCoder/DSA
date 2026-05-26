package MonotonicStack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] nums = { 2 , 2, 1 , 5 , 6 , 2 , 4 };
        int[] result = nextGreater(nums);
        for(int n : result) {
            System.out.print(n + " ");
        }
        System.out.println();
        result = nextSmaller(nums);
        for(int n : result) {
            System.out.print( n + " ");
        }
    }

    public static int[] nextGreater(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for(int i = 0 ; i < nums.length; i++) {

            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            result[stack.pop()] = -1;  // Default Value for remaining indices
        }
        return result;
    }

    public static int[] nextSmaller(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for(int i = 0 ; i < nums.length ; i ++) {
             
            while(!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }
}