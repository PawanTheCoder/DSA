package Hashes.FrequencyCount;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Leetcode347 {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int[] ans = topKFrequent(nums, 2);
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num , map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);
        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort((a , b) -> map.get(b) - map.get(a));

        int[] ans = new int[k];
        for(int i =0 ;i < k ; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
