package DailyChallenges.JuneChallenges;

import java.util.HashMap;
import java.util.Map;

public class June22 {
    public static void main(String[] args) {

        String text = "loonalxallpoon";
        String b = "balon";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: b.toCharArray()) {
            map.put(c, 0);
        }
  
        for (char c : text.toCharArray()) {
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                map.put(c, map.get(c) + 1);
            }
        }
        int minimumFreq = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getKey() == 'o' || entry.getKey() == 'l') {
                minimumFreq = Math.min(entry.getValue() / 2 , minimumFreq);
            }
            minimumFreq = Math.min(entry.getValue() , minimumFreq);
        }

        System.out.println(minimumFreq);
    }
}