package SlidingWindow.FrequencyCount;

import java.util.Arrays;

public class Leetcode1838 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 7};
        int k = 5;
        System.out.println(maxFrequency(nums, k));
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans =0;
        int left =0;
        long sum =0;

        // Sliding Window
        for(int right =0 ; right < nums.length; right++) {
            sum += nums[right];

            while((long) (nums[right] * (right - left + 1))- sum > k) {
                sum -= nums[left];
                left++;
            }

            ans = Math.max(ans , right - left + 1);
        }
        return ans;
    }
}