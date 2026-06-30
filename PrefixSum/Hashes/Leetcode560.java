package PrefixSum.Hashes;

import java.util.HashMap;

public class Leetcode560 {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        int ans = subarraySum(nums, k);
        System.out.println(ans);
    }

    public static int subarraySum(int[] nums, int k) {
        int count =0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int prefix =0;
        map.put(0,1);

        for(int num : nums) {
            prefix += num;

            count += map.getOrDefault((prefix - k ), 0);

            map.put(prefix , map.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }
}
