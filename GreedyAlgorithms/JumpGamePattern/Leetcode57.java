package GreedyAlgorithms.JumpGamePattern;

public class Leetcode57 {
    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        boolean canReach = canJump(arr);
        System.out.println(canReach);
    }
    public static boolean canJump(int[] nums) {
        int farthest = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if(i >farthest)  return false;
            farthest = Math.max(farthest, i + nums[i]);
            if(farthest == nums.length - 1) return true;
        }
        return true;
    }
}