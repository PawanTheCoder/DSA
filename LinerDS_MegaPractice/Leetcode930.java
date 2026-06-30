package LinerDS_MegaPractice;

import java.util.Arrays;
import java.util.HashMap;

public class Leetcode930 {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,1};
        int goal = 3;
        int ans = numSubarraysWithSum(nums , goal);
        System.out.println(ans);
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int count =0;
        int prefix =0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int num : nums) {
            prefix += num;

            count += map.getOrDefault(goal - prefix, 0);

            map.put(prefix , map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }
}