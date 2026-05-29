package GreedyAlgorithms.JumpGamePattern;

public class Leetcode45 {
    public static void main(String[] args) {
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        int ans = jump(nums);
        System.out.println(ans);
    }
    public static int jump(int[] nums) {
        int jump = 0;
        int farthest = 0;
        int currentEnd = 0;
        for(int i =0 ; i < nums.length ; i++) {
            farthest = Math.max(farthest , i + nums[i]);

            if( i== currentEnd) {
                jump++;
                currentEnd = farthest;

                if(farthest >= nums.length -1) {
                    break;
                }
            }
        }
        return jump;
    }
}
