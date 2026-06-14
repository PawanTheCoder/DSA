package SlidingWindow.FrequencyCount;

public class Leetcode3689 {
    public static void main(String[] args) {
        int[] nums = {15 , 50 , 27};
        int k = 1;
        System.out.println(maxTotalValue(nums, k));
    }

    public static long maxTotalValue(int[] nums, int k) {
        int windowSize;
        if(k > nums.length) windowSize = nums.length -1;
        else windowSize = k;

        System.out.println(windowSize);

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE; 
        // Find the min max of first window
        for(int i= 0; i <= windowSize; i++) {
            maxValue = Math.max(maxValue, nums[i]);
            minValue = Math.min(minValue , nums[i]);
        }

        System.out.println( maxValue - minValue);
        
        int diff = maxValue - minValue;


        return diff * k;
    }
}
