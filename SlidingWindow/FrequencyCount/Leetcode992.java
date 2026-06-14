package SlidingWindow.FrequencyCount;

import java.util.HashMap;

public class Leetcode992 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        System.out.println(subarraysWithKDistinct(nums, 2));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums , k) - atMost(nums , k- 1);
    }

    public static int atMost(int[] nums , int k) {
        HashMap<Integer , Integer> freq = new HashMap<>();

        int left =0;
        int count =0;

        for(int right =0; right < nums.length; right++) {
            freq.put(nums[right] , freq.getOrDefault(nums[right], 0) + 1);

            while(freq.size() > k) {
                freq.put(nums[left] , freq.getOrDefault(nums[left], 0) -1);

                if(freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }

            count += right -left +1;
        }

        return count;
    }
}
