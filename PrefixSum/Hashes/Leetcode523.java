package PrefixSum.Hashes;

import java.util.HashMap;

public class Leetcode523 {
    public static void main(String[] args) {
        int[] nums = {23,2,1, 6,7};
        int k = 6;
        boolean ans = checkSubarraySum(nums, k);
        System.out.println(ans);
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefix =0;
        map.put(0,1);

        for(int i=0; i < nums.length ; i++) {
            prefix += nums[i];

            int rem = (prefix % k + k) %k;

            if(map.getOrDefault(rem, 0) >0 ) {
                if(nums[i] % k == 0) {
                    if(i > 0 && nums[i -1] % k ==0) {
                        return true;
                    }
                    continue;
                }
                return true;
            }

            map.put(rem , map.getOrDefault(rem , 0) + 1);
        }
        return false;
    }
}
