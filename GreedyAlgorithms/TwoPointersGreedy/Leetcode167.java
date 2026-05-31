package GreedyAlgorithms.TwoPointersGreedy;

public class Leetcode167 {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] ans = twoSum(numbers, target);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                break;
            }else if (sum < target) {
                left ++;
            }else {
                right --;
            }
        }
        int[] ansArr = {left + 1 , right + 1};
        return ansArr;
    }
}
