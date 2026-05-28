package GreedyAlgorithms;

import java.util.Arrays;

public class Leetcode56 {
    public static void main(String[] args) {
        
        int[][] intervals = {{1 , 4} , {2 , 3}};
        int[][] ans = merge(intervals);
        for(int i =0 ; i < ans.length ; i++) {
            for(int j =0 ; j <=1 ; j++) {
                System.out.println(ans[i][j]);
            }
        }
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a , b) -> Integer.compare(a[0], b[0]));
        int[][] ans = new int[intervals.length][2];
        int count = 0;
        int startElement = intervals[0][0];
        int endElement = intervals[0][1];

        for(int i =1 ; i < intervals.length ; i++) {
            if(intervals[i][0] <=endElement && endElement > intervals[i][1]) {
                continue;
            }
            if(intervals[i][0] <= endElement) {
                endElement = intervals[i][1];
            }else {
                ans[count][0] = startElement;
                ans[count][1] = endElement;
                count++;
                startElement = intervals[i][0];
                endElement = intervals[i][1];
            }
        }
        
            ans[count][0] = startElement;
            ans[count][1] = endElement;
        
        count++;

        return Arrays.copyOf(ans, count);
    }
}
