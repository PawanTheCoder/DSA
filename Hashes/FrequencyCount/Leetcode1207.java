package Hashes.FrequencyCount;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Leetcode1207 {
    public static void main(String[] args) {
        int[] arr = {1 ,2 , 2, 1 , 0 , 3};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int num : arr) {
            map.put(num , map.getOrDefault(num, 0) + 1);
        }

        // Now we have frequency of every element occuring in the map 
        // Now we have to Loop through map to find the either array contains unique occurence or not

        Set<Integer> set = new HashSet<>(map.values());

        if(set.size() != map.size()) return false;
        
        return true;
    }
}
