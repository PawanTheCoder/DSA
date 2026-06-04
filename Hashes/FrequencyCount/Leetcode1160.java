package Hashes.FrequencyCount;

import java.util.HashMap;

public class Leetcode1160 {
    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";

        System.out.println(countCharacters(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        HashMap<Character , Integer> freq = new HashMap<>();

        int totoalLength = 0;
        for(String s : words) {
            
        for(char c : chars.toCharArray()) {
            freq.put(c , freq.getOrDefault(c, 0) + 1);
        }
            boolean needToAdd = false;
            for(char c : s.toCharArray()) {
                if(!freq.containsKey(c) || freq.get(c) == 0) {
                    needToAdd = false;
                    break;
                }
                freq.put(c , freq.get(c) - 1);
                needToAdd = true;
            }

            if(needToAdd) {
                totoalLength += s.length();
            }
            freq.clear();
        }

        System.out.println(freq);
        return totoalLength;
    }
}
