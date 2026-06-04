package Hashes.FrequencyCount;

import java.util.HashMap;
import java.util.Map;

public class Leetcode383 {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";

        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : magazine.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for(char ch : ransomNote.toCharArray()) {
            if(!freq.containsKey(ch) || freq.get(ch) == 0) {
                return false;
            }

            freq.put(ch , freq.get(ch) - 1);
        }

        System.out.println(freq);
        return true;

    }
}
