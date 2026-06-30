// Success

package LinerDS_MegaPractice;

import java.util.HashMap;

public class Leetcode451 {
    public static void main(String[] args) {
        String s = "tree";

        String ans = frequencySort(s);
        System.out.println(ans);
    }

    public static String frequencySort(String s) {
        StringBuilder str = new StringBuilder();
        HashMap<Character , Integer> map = new HashMap<>();
        // Enumerate through string
        for(char c : s.toCharArray()) {
            map.put(c , map.getOrDefault(c , 0) + 1);
        }

        System.out.println(map);
        while(!map.isEmpty()) {
            int maxFreq =0;
            char currentChar = 'k';
            for(char c : map.keySet()) {
                maxFreq = Math.max(maxFreq , map.get(c));
                if(maxFreq == map.get(c)) {
                    currentChar = c;
                }
            }

            for(int i =0;i < maxFreq ; i++) {
                str.append(currentChar);
            }    
            map.remove(currentChar);
        }
        return str.toString();
    }
}
