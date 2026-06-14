package SlidingWindow.FrequencyCount;

import java.util.HashSet;

public class Leetcode904 {
    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
       int maxlen =0;
       HashSet<Integer> set = new HashSet<>();

       int left =0;

       for(int right =0;right < fruits.length ; right ++) {
        set.add(fruits[right]);

        if(set.size() == 3) {
            set.clear();
            set.add(fruits[right]);
            set.add(fruits[right - 1]);
            left = right -1;
            int num  = fruits[left];
            while(fruits[left] == num) left--;
            left++;
        }

        maxlen = Math.max(maxlen , right - left + 1);
       }
       return maxlen;
    }
}
