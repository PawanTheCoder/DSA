package PrefixSum.Hashes;

public class Leetcode3737 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1};
        int target = 2;
        int ans = countMajoritySubarrays(nums, target);
        System.out.println(ans);
    }
    public static int countMajoritySubarrays(int[] nums, int target) {
        int count =0;
        int left =0;
        int right =0;

        while(right < nums.length) {
            if(nums[right] == target) {
                int targetCount =0;
                left = right;
                while(left >= 0 && nums[left] <=target) {
                    if(nums[left] == target) {
                        targetCount ++;
                    }
                    left --;            
                }

                System.out.println("Left : " + left);

                while(right < nums.length && nums[right] <= target) {
                    if(nums[right] == target) {
                        targetCount++;
                    }
                    right ++;      
                }
                if(right == nums.length) {
                    right = right -1;
                }
                if(left  == -1) {
                    left = left + 1;
                }
                int windowSize = right - left + 1;
                System.out.println(windowSize);
                count += (windowSize * (windowSize + 1) / 2) - windowSize + targetCount;
            }
            right ++;
        }

        return count;
    }
}
