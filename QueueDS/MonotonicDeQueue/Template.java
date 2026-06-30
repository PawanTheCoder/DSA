package QueueDS.MonotonicDeQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Template {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};

        int[] ans = maxSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(ans));

    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int count =0;
        for(int i =0; i < nums.length; i++) {
            
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                
                deque.pollLast();
            }
            deque.offerLast(i);  
            if(!deque.isEmpty() &&  deque.peekFirst() <= i -k) {
                deque.pollFirst();
            }
            if(i + 1 >= k ) {
                arr.add(nums[deque.peekFirst()]);
            }
        }   
        int[] result = new int[arr.size()];

        for(int num : arr) {
            result[count++] = num;
        }
        return result;
    }
}
