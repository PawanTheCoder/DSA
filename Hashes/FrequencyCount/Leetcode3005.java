package Hashes.FrequencyCount;

import java.util.HashMap;

public class Leetcode3005 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,1};
        int ans = maxFrequencyElements(nums);
        System.out.println(ans);
    }

    public static int maxFrequencyElements(int[] nums) {
        int ans = 0;
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num , map.getOrDefault(num, 0) + 1);
        }

        int maxValue = Integer.MIN_VALUE;
        for(Integer value : map.values()) {
            maxValue = Math.max(value , maxValue);
        }

        for(int num : nums) {
            if(map.get(num) == maxValue) {
                ans+=1;
            }
        }
        return ans;
    }
}
