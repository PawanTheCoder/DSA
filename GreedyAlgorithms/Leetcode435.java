package GreedyAlgorithms;

import java.util.Arrays;

public class Leetcode435 {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int ans = eraseOverlapIntervals(intervals);
        System.out.println(ans);
    }
     public static int eraseOverlapIntervals(int[][] intervals) {
        // Sort by endtime (Greedy Approach)
        Arrays.sort(intervals , (a,b) -> a[1] - b[1]);
        int count = 1;
        int lastEnd = intervals[0][1];

        for(int i = 0 ; i < intervals.length ; i++) {
            if(intervals[i][0] >= lastEnd ) {
                // Accpet the interval
                count ++;
                lastEnd = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}
