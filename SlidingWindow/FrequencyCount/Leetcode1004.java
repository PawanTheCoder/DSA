package SlidingWindow.FrequencyCount;

public class Leetcode1004 {
    public static void main(String[] args) {
        int nums[] = {1 ,1 ,1 , 0 , 0 , 0 , 1 ,1};
        int k =2;
        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int ans =0;
        int left =0;
        int zeroCount =0;

        for(int right =0;right < nums.length; right ++) {
            if(nums[right]  == 0) {
                zeroCount++;
            }

            while(zeroCount > k) {
                if(nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            ans = Math.max(ans , right - left + 1);
        }
        return ans;
    }
}
