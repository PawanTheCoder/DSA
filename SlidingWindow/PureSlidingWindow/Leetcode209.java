package SlidingWindow.PureSlidingWindow;

public class Leetcode209 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int minimumSize = minSubArrayLen(target, nums);
        System.out.println(minimumSize);
    }


    public static int minSubArrayLen(int target, int[] nums) {
        int currentSum = 0;
        int left =0;
        int right = 0;
        int currentWindow =0;
        int minWindow = Integer.MAX_VALUE;
        boolean signal = true;
        while(left < nums.length) {
            if(signal) {
                currentSum += nums[right];
                System.out.println(currentSum);
                currentWindow ++;
            }
            
            while(left <= right && currentSum >= target) {
                minWindow = Math.min(minWindow , currentWindow);
                currentSum -= nums[left];
                left++;
                currentWindow --;
                System.out.println(nums[left] + " " + nums[right]);
            }
            if(currentSum < target && signal) {
                right++;
            }
            if(!signal) {
                left++;
            }
            
            if(right == nums.length) signal = false;
        }
        if(minWindow == Integer.MAX_VALUE) return 0;
        return minWindow;
    }
}
