package DailyChallenges.JuneChallenges;

import java.util.Arrays;

public class June6th {
    public static void main(String[] args) {
        int[] nums = {10 , 4 , 8 , 3};
        int[] ans = leftRightDifference(nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] leftRightDifference(int[] nums) {
        int[] ans = new int[nums.length];

        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int currentSum =0;
        for(int i =0; i < nums.length ; i++) { 
            leftSum[i]  = currentSum;
            currentSum += nums[i];
        }
        currentSum = 0;
        for(int j = nums.length - 1; j >=0 ; j--) {
            rightSum[j] = currentSum;
            currentSum += nums[j];
        } 
        for(int i =0 ; i < nums.length ; i++) {
            ans[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return ans;
    }
}