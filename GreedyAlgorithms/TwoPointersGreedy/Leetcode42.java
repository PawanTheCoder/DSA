package GreedyAlgorithms.TwoPointersGreedy;

public class Leetcode42 {
    public static void main(String[] args) {
        int[] height = {4 , 2 , 0 , 3 , 2 , 5};
        int ans = trap(height);
        System.out.println(ans);
    }
    public static int trap(int[] height) {
        if(height.length == 0 || height.length < 3) return 0;
        int left =0;
        int right =height.length - 1;
        int water = 0;
        int leftMax = 0;
        int rightMax = 0;

        while(left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax , height[right]);

            if(leftMax < rightMax) {
                // Water trapped at left 
                water += leftMax - height[left];
                left++;
            }else {
                // Water trapped at right
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}
