package Hashes.FrequencyCount;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Leetcode1838 {
    public static void main(String[] args) {
        int[] nums = { 9940,9995,9944,9937,9941,9952,9907,9952,9987,9964,9940,9914,9941,9933,9912,9934,9980,9907,9980,9944,9910,9997};
        int ans = maxFrequency(nums, 7925);

        System.out.println(ans);
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums); 
        int index =0; 
        for(int i =0 ; i < k ; i++) {
            int minDiff = Integer.MAX_VALUE;
            for(int j =nums.length - 1 ; j >= 1; j--) {
                int diff = nums[j] - nums[j -1];
                if(diff< minDiff && diff != 0) {
                    minDiff = diff;
                    index = j -1 ;
                }
            } 
            nums[index] += 1;
            while(index < nums.length -1 && nums[index] > nums[index + 1]) {
                int temp = nums[index];
                nums[index] = nums[index + 1];
                nums[index + 1] = temp;
                index += 1;
            }
        }
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num , map.getOrDefault(num, 0) + 1);
        }
        int maxValue = Collections.max(map.values());
        System.out.println(map);
        return maxValue;
    }
}
