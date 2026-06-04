package GreedyAlgorithms.TwoPointersGreedy;

import java.util.Stack;


public class Leetcode84 {
    public static void main(String[] args) {
        int[] heights = {3 , 7 , 10 , 5 , 4, 2};

        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int[] extendedHeights = new int[heights.length + 1];

        System.arraycopy(heights , 0 , extendedHeights , 0 , heights.length);
        // Adding Sential
        extendedHeights[heights.length] = 0;

        for(int i = 0 ; i < extendedHeights.length ; i++) {
            
            
            while(!stack.isEmpty() && extendedHeights[i] < extendedHeights[stack.peek()]) {
                int popedIndex = stack.pop();
                int height = extendedHeights[popedIndex];
                int width;

                
                if(stack.isEmpty()) {
                    width = i;
                }
                else {
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea , height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
