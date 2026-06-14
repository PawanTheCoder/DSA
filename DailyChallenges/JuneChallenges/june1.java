package DailyChallenges.JuneChallenges;
// 2144. Minimum Cost of Buying Candies With Discount

import java.util.Arrays;

public class june1 {
    public static void main(String[] args) {
        int[] cost = { 6,5,7,9,2,2};
        int totalCost = minimumCost(cost);
        System.out.println(totalCost);
    }

    public static int minimumCost(int[] cost) {
           int totalCost = 0;
        if (cost.length == 1)
            return cost[0];
        if (cost.length == 2)
            return cost[0] + cost[1];
        Arrays.sort(cost);

        int left = 0;
        int right = cost.length - 1;

        while (left < right) {
            int temp = cost[left];
            cost[left] = cost[right];
            cost[right] = temp;

            left++;
            right--;
        }
        for (int num : cost) {
            System.out.print(num + " ");
        }
        int i = 0;
        int j = 1;
        while(i <=cost.length - 2 && j < cost.length) {
            totalCost += cost[i] + cost[j];

            i = i + 3;
            j = i + 1;
        }

        if(i == cost.length - 1) {
            totalCost += cost[cost.length - 1];
        }
        return totalCost;
    }
}
