package PrefixSum.Hashes;

import java.util.HashMap;

public class Leetcode974 {
    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        int ans = subarraysDivByK(nums, k);
        System.out.println(ans);
    }

    public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();

        int count=0;
        int prefix =0;
        map.put(0 , 1);
        for(int num : nums) {
            prefix += num;

            int rem = ((prefix % k ) + k ) % k;
            count += map.getOrDefault(rem , 0);

            map.put(rem , map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}
