package SlidingWindow.PureSlidingWindow;

public class Leetcode930 {
    public static void main(String[] args) {
        int[] nums = {0 , 0 , 0 , 0 ,0};
        int k =0;
        System.out.println(numSubarraysWithSum(nums, k));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal -1);
    }

    public static int atMost(int[] nums , int goal) {

        if(goal < 0) return 0;
        int count =0;
        int left =0;
        int sum =0;

        for(int right =0 ; right < nums.length; right ++) {
            sum += nums[right];

            while(sum > goal) {
                sum -= nums[left++];
            }

            count += right - left + 1;
        }
        return count;
    }
}
