package SlidingWindow.PureSlidingWindow;

public class Leetcode643 {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        double ans = findMaxAverage(nums, 4);
        System.out.println(ans);
    }
    public static double findMaxAverage(int[] nums, int k) {
        double currentSum = 0;

        int left =0;
        double finalAvg = 0.00000;

        for(int right =0 ; right < nums.length ; right++) {
            currentSum += nums[right];
            if(right - left + 1 > k) {
                currentSum -= nums[left];
                left ++;
            }
            if(right - left +1 == k) {
                finalAvg = Math.max(currentSum / k , finalAvg);
            }
        }

        return finalAvg;
    }
}
