package GreedyAlgorithms.TwoPointersGreedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Leetcode15 {
    public static void main(String[] args) {
        int[] nums = {0,0,0 , 0};
        List<List<Integer>> ans = threeSum(nums);
        System.out.println(ans);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        // List<Integer> numClone = new ArrayList<>();
        // for(int num : nums) {
        //     numClone.add(num);
        // }

        // Collections.sort(numClone);
        // System.out.println(numClone);
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int k = 1 ; k <= nums.length -2 ; k++) {
            int i = 0;
            int j = nums.length - 1;
           while(i < k && j >k) {
            int sum = nums[i] + nums[j] + nums[k];
             if(sum == 0) {
                List<Integer> subAns = new ArrayList<>(); 
                subAns.add(nums[i]);
                subAns.add(nums[j]);
                subAns.add(nums[k]);
                if(!ans.contains(subAns)) {
                    ans.add(subAns);
                }
                i++;
                j--;
            }
            if(sum < 0) {
                i++;
            }else if(sum > 0) {
                j--;
            }
           }
        }
        return ans;
    }
}