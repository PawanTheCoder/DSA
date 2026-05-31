package GreedyAlgorithms.IntervalPattern;

import java.util.Arrays;

public class Leetcode2126 {
    public static void main(String[] args) {
        int[] asteriods = {4,9,23,4};
        boolean willSurvive = asteroidsDestroyed(5, asteriods);
        System.out.println(willSurvive);
    }
    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for(int num : asteroids) {
            if(num > mass) {
                return false;
            }else {
                mass += num;
            }
        } 
        System.out.println(mass);
        return true;
    }
}
