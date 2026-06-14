package SlidingWindow.FrequencyCount;

public class Leetcode1439 {
    public static void main(String[] args) {
        int[] nums = {1 ,1 ,1 ,0 ,1 ,0 ,1};
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
       int ans = 0;
       int left =0;
       int zeros = 0;
       for(int right =0; right < nums.length ; right++) {
        if(nums[right] == 0) {
           zeros ++;
        }

        while(zeros > 1) {
            if(nums[left] == 0) {
                zeros--;
            }
            left++;
        }

        ans = Math.max(right - left + 1, ans);
       }
       return ans;
    }
}
