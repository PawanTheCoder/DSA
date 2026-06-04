package Hashes.FrequencyCount;

import java.util.ArrayList;
import java.util.HashMap;


public class Leetcode350 {
    public static void main(String[] args) {
        // nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        int[] nums1 = {4 , 9 , 5};
        int[] nums2 = {9 , 4 , 9 , 8 , 4};

        int[] ans = intersect(nums1, nums2);


        for(int num : ans) {
            System.out.print(num + " ");
        }
    } 

    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer , Integer> mapOfNum1 = new HashMap<>();

        for(int num : nums1) {
            mapOfNum1.put(num , mapOfNum1.getOrDefault(num, 0) + 1);
        }


        System.out.println(mapOfNum1 );

        for(int num : nums2) {
            if(mapOfNum1.containsKey(num) && mapOfNum1.get(num) > 0) {
                arr.add(num);
                mapOfNum1.put(num , mapOfNum1.get(num) - 1);
            }
        }

        int[] ans = new int[arr.size()];
        int index =0;
        for(int num : arr) {
            ans[index++] = num;
        }
        return ans;
    }
}
