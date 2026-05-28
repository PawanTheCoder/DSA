package MonotonicStack;

import java.util.*;

public class Leetcode2554 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5};
        int[] result = secondGreaterElement(nums);
        for(int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] secondGreaterElement(int[] nums) {
        int[] result = new int[nums.length];
        ArrayList<Integer> arr = new ArrayList<>();
        int[] isValid = new int[nums.length];
        Arrays.fill(result , -1);

        for(int i = 0 ; i < nums.length ; i++) {
            isValid[i] = 0;
        }

        for(int i = 0 ; i < nums.length ; i++) {
            for(int j = 0 ; j <arr.size() ; j++) {
                int index = arr.get(j);
                if(nums[i] > nums[arr.get(j)] && isValid[index] == 0) {
                    isValid[index] = 1;
                    continue;
                }
                if(nums[i] > nums[arr.get(j)] && isValid[index] == 1) {
                    result[index] = nums[i];
                    isValid[index] = -1;
                    arr.remove(j);
                    j--;
                }
            }
            arr.add(i);
        }

        return result;
    }
    
}
