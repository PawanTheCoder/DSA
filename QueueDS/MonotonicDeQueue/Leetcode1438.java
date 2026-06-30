package QueueDS.MonotonicDeQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode1438 {
    public static void main(String[] args) {
        int[] nums = {8,2,4,7};
        int ans = longestSubarray(nums, 4);

        System.out.println("Ans : " + ans);
    }

    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();

        int maxWindowSize =0;
        int left =0;

        for(int right =0; right < nums.length ; right ++) {
            while(!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[right]) {
                maxQ.pollLast();
            }

            while(!minQ.isEmpty() && nums[minQ.peekLast()] > nums[right]) {
                minQ.pollLast();
            }

            minQ.offer(right);
            maxQ.offer(right);

            while(nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > limit) {
                if(left == maxQ.peekFirst()) {
                    maxQ.pollFirst();
                }

                if(left == minQ.peekFirst()) {
                    minQ.pollFirst();
                }
                left ++;
            }

            maxWindowSize = Math.max(maxWindowSize , right - left + 1);
        }
        return maxWindowSize;
    }
}

