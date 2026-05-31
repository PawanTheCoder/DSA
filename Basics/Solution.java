package Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        int n = 122;
        System.out.println(digitFrequencyScore(n));
    }
    public static  int digitFrequencyScore(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        int number= n;
        while(number != 0) {
            set.add(number % 10);
            arr.add(number % 10);
            number = number / 10;
        }
        System.out.println(arr);
        System.out.println(set);
        int[] frequency = new int[10];
        Arrays.fill(frequency , 0);
        for(int num : arr) {
            frequency[num] ++;
        }

        int ans = 0;
        for(int num : set) {
            ans += num * frequency[num];
        }

        return ans;
    }
}