package Hashes.FrequencyCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode229 {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 3 };
        List<Integer> ans = majorityElement(nums);
        System.out.println(ans);
    }

    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        System.out.println(freq);

        for (int key : freq.keySet()) {
            if (freq.get(key) > n / 3) {
                arr.add(key);
            }
        }

        return arr;
    }
}
