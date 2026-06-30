// Editorial

package LinerDS_MegaPractice;

import java.util.HashMap;

public class Leetcode862 {
    public static void main(String[] args) {
        int[] nums = {1 , 2};
        int ans = shortestSubarray(nums, 4);
        System.out.println(ans);
    }

    public static int shortestSubarray(int[] nums, int k) {
        HashMap<Integer, Integer> distances = new HashMap<>();
        distances.put(0, 0);

        int prefix =0;
        int minDistance = Integer.MAX_VALUE;

        for(int i=1; i < nums.length + 1; i++) {
            prefix += nums[i -1 ];

            if(distances.getOrDefault(prefix - k , -1) >= 0) {
                minDistance = Math.min(minDistance , i - distances.get(prefix - k));
            }

            distances.put(prefix , i);
        }
        if(minDistance == Integer.MAX_VALUE) return -1;
        return minDistance;
    }
}
