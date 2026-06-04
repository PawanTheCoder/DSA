package Hashes.FrequencyCount;

import java.util.HashMap;

public class Leetcode961 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
         HashMap<Integer , Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        for(int num : nums) {
            // System.out.println(map.get(num));
            if(map.get(num) * 2 == nums.length) { 
                System.out.println(num);
                break;
            }
        }
    }
}
