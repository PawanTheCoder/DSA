package Hashes.BasicTemplate;
import java.util.*;

public class Leetcode349 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] ans= intersection(nums1, nums2);
        for(int i =0 ; i < ans.length ; i++) {
            System.out.print(ans[i] + " ");
        }
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        for(int num: nums1) {
            set1.add(num);
        }

        for(int num : nums2) {
            if(set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert to int array
        int[] result = new int[resultSet.size()];
        int i = 0;
        for(int num : resultSet) {
            result[i++] = num;
        }

        return result;
    }
}
