package Hashes.FrequencyCount;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Leetcode451 {
    public static void main(String[] args) {
        String s = "Aaabbbbb";
        String ans = frequencySort(s);
        System.out.println(ans);
    }

    public static String frequencySort(String s) {
        HashMap<Character , Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()) {
            freq.put(c , freq.getOrDefault(c, 0) + 1);
        }

        // Now we have got the frequency of each character 
        // We have to built a new String using this info
        StringBuilder str = new StringBuilder();
        List<Character> list = new ArrayList<>(freq.keySet());
        System.out.println(list);
        list.sort((a , b) -> freq.get(b) - freq.get(a));
        System.out.println(list);
        System.out.println(freq);
        for(char c : list) {
            for(int i =0 ; i < freq.get(c) ; i++) {
                str.append(c);
            }
        }
        return str.toString();
    }
}
