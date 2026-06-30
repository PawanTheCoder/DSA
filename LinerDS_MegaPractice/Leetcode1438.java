package LinerDS_MegaPractice;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode1438 {
    public static void main(String[] args) {
        int[] nums = {10,1,2,4,7,2};
        int ans = longestSubarray(nums, 5);
        System.out.println("Ans : " + ans);
    }

    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();
        int maxWindowSize = 0;
        int left =0;

        for(int right=0; right < nums.length ; right++) {
            while(!maxQ.isEmpty() && nums[right] > nums[maxQ.peekLast()]) {
                maxQ.pollLast();
            }

            while(!minQ.isEmpty() && nums[right] < nums[minQ.peekLast()]) {
                minQ.pollLast();
            }
            maxQ.offerLast(right);
            minQ.offerLast(right);

            while(nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > limit) {
                if(nums[left]== nums[maxQ.peekFirst()]) maxQ.pollFirst();
                if(nums[left] == nums[minQ.peekFirst()]) minQ.pollFirst();
                left ++;
            }
            maxWindowSize = Math.max(maxWindowSize , right - left + 1);
        }
        return maxWindowSize;
    }
}