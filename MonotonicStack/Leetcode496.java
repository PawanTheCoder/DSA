package MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode496 {
    public static void main(String[] args) {
        int[] nums1 = { 2 , 4 };
        int[] nums2 = { 1 , 2 , 3 ,4};

        int[] result = nextGreaterElement(nums1, nums2);

        for(int n : result) {
            System.out.print( n + " ");
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] nums2Result = new int[nums2.length];
        int[] nums1Result = new int[nums1.length];

        Arrays.fill(nums1Result , -1);

        for(int i = 0 ; i < nums2.length; i++) {

            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int index = stack.pop();
                nums2Result[index] = nums2[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            nums2Result[stack.pop()]  = -1;
        }

        for(int i = 0 ; i < nums1.length ; i++) {
            for(int j = 0 ; j < nums2.length ; j++) {
                if(nums1[i] == nums2[j]) {
                    nums1Result[i] = nums2Result[j];
                }
            }
        }


        return nums1Result;
    }
}
