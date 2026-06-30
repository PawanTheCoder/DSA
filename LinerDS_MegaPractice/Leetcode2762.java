package LinerDS_MegaPractice;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode2762 {
    public static void main(String[] args) {
        int[] nums = {5,4,2,4};
        System.out.println(continuousSubarrays(nums));
    }
    public static long continuousSubarrays(int[] nums) {
        long ans =0;
        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();

        int left =0;
        for(int right =0; right < nums.length ; right ++) {
            while(!maxQ.isEmpty() && nums[right] > nums[maxQ.peekLast()]) {
                maxQ.pollLast();
            }

            while(!minQ.isEmpty() && nums[right] < nums[minQ.peekLast()]) {
                minQ.pollLast();
            }

            maxQ.offerLast(right);
            minQ.offerLast(right);

            while(Math.abs(nums[maxQ.peekFirst()] - nums[minQ.peekFirst()]) > 2) {
                if(nums[left] == nums[maxQ.peekFirst()]) {
                    maxQ.pollFirst();
                }
                if(nums[left] == nums[minQ.peekFirst()]) {
                    minQ.pollFirst();
                }
                left ++;
            }
            ans += right -left + 1;
        }
        return ans;
    }
}
