package Hashes.FrequencyCount;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Leetcode290 {
    public static void main(String[] args) {
        //  pattern = "", s = ""

        String pattern = "baab";
        String s = "dog cat cat dog";

        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;

        int count =0;
        HashMap<Character , String> map = new HashMap<>();
        for(char c : pattern.toCharArray()) {
            if(map.containsKey(c) && !map.get(c).equals(words[count])) {
                System.out.println(map.get(c) + " " + words[count]);
                return false;
            }
            map.put(c , words[count]);
            count++;
        }

        Set<String> seen = new HashSet<>();
        for (String value : map.values()) {
            if (!seen.add(value)) {
                return false; // duplicate value found
            }
        }
        System.out.println(map);
        return true;
    }
}

