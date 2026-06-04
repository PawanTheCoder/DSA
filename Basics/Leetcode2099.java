package Basics;

import java.util.Arrays;

public class Leetcode2099 {
    public static void main(String[] args) {
        int[] nums = {-1,-2,3,4};
        int[] ans = maxSubsequence(nums, 3);
        for(int num : ans) {
            System.out.print(num + " ");
        }
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        int[] copyNums = Arrays.copyOf(nums , nums.length);

        for(int num : copyNums) {
            System.out.print( num + " ");
        }
        System.out.println();
        int[] indices = new int[k];

        for(int i = 0 ;i < k; i++) {
            int maxNum = Integer.MIN_VALUE;
            for(int j = 0 ;j  < nums.length ; j ++) {
                if(nums[j] > maxNum) {
                    indices[i] = j;
                    maxNum = nums[j];
                }
            }
            nums[indices[i]] = Integer.MIN_VALUE;
        }
        // int[] ansArray = new int[k];
        Arrays.sort(indices);
        for(int i = 0 ; i < k; i++) {
            indices[i] = copyNums[indices[i]];
        }
        return indices;
    }
}
