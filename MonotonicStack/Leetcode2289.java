package MonotonicStack;

import java.util.ArrayList;
import java.util.Stack;

public class Leetcode2289 {
    public static void main(String[] args) {
        int[] arr = {5,3,4,4,7,3,6,11,8,5,11};
        int ans = totalSteps(arr);
        System.out.println(ans);
    }
    public static int totalSteps(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i : nums) {
            arr.add(i);
        }

        int ans = 0;
        for(int i = 1 ; i < arr.size() ; i++) {
            if(arr.get(i) > arr.get(i - 1)) {
                stack.push(i - 1);
            }
        }
        return ans;
    }
}
