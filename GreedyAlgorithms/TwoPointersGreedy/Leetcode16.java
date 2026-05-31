package GreedyAlgorithms.TwoPointersGreedy;

import java.util.Arrays;

public class Leetcode16 {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int ans = threeSumClosest(nums, 1);
        System.out.println(ans);
    }

     public static int threeSumClosest(int[] nums, int target) {
         Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int k = 0; k < nums.length - 2; k++) {
            int i = k + 1;
            int j = nums.length - 1;

            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];

                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return closestSum;
    }
}
