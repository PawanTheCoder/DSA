package GreedyAlgorithms.TwoPointersGreedy;

public class Leetcode11 {
    public static void main(String[] args) {
        int[] height = {1 , 8 , 6 , 2, 5 , 4 , 8 , 3, 7};
        int ans = maxArea(height);
        System.out.println(ans);
    }
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int area = 0;
        while(i <= j) {
            area = Math.max( area , Math.min(height[i] , height[j]) * Math.abs( i - j));
            if(height[i] < height[j]) {
                i++;
            }else {
                j--;
            }
        }
        return area;
    }
}
