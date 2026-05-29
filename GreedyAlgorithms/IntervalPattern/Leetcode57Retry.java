package GreedyAlgorithms.IntervalPattern;

import java.util.Arrays;

public class Leetcode57Retry {
    public static void main(String[] args) {
        int[][] interval = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        int[][] ans = insert(interval, newInterval);
        for(int i =0 ;i < ans.length ; i++) {
            System.out.println(ans[i][0] + ", " + ans[i][1]);
        }
    }
   public static int[][] insert(int[][] intervals, int[] newInterval) {
       int[][] finalInterval = new int[intervals.length + 1][2];
       int i = 0;
       // Add the Intervals before of the new interval
       while(i < intervals.length && intervals[i][1] < newInterval[0]) {
        finalInterval[i][0] = intervals[i][0];
        finalInterval[i][1] = intervals[i][1];
        i++;
       }
       int index = i;

       // Overlap the newInterval along with neighbour intervals 
       while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = Math.min(intervals[i][0] , newInterval[0]);
        newInterval[1] = Math.max(intervals[i][1] , newInterval[1]);
        i++;
       }
       finalInterval[index][0] = newInterval[0];
       finalInterval[index][1] = newInterval[1];
       index++;
       // Add the remaining intervals
       while(i < intervals.length) {
        finalInterval[index][0] = intervals[i][0];
        finalInterval[index][1] = intervals[i][1];
        i++;
        index++;
       }
       return Arrays.copyOf(finalInterval, index);
    }
}
