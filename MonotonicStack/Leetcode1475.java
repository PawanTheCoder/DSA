package MonotonicStack;

import java.util.Stack;

public class Leetcode1475 {
    public static void main(String[] args) {
        int[] prices = { 10,1,1,6};
        int[] result = finalPrices(prices);
        for(int n : result) {
            System.out.println(n);
        }
    }

    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[prices.length];
        for(int i = 0 ; i < prices.length ; i++) {

            while(!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop();
                result[index] = prices[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }
        for(int i = 0 ; i < result.length; i++) {
            result[i] = prices[i] - result[i];
        }
        return result;
    }
}
