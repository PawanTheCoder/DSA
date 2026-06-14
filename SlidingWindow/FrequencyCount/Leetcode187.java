package SlidingWindow.FrequencyCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Leetcode187 {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }

    public static List<String> findRepeatedDnaSequences(String s) {

        if (s.length() <= 10) return new ArrayList<>();
        HashMap<String , Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        // Creating First Window
        int k = 10;
        StringBuilder str = new StringBuilder();
        for(int i =0 ; i < k ; i++) {
            str.append(s.charAt(i));
        }
        // Add the first window to the HashMap
        map.put(str.toString() , 0);

        for(int i =1 ; i <= s.length() -10;i++) {
            str.append(s.charAt(i + 10 -1));
            str.deleteCharAt(0);
            String newStr = str.toString();
            System.out.println(newStr);
            if(map.containsKey(newStr)) {
                System.out.println("Contains");
                set.add(newStr);
                continue;
            }
            map.put(newStr , 0);
        }

        return new ArrayList<>(set);
    }
}
