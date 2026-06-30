package QueueDS.DeQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode649 {
    public static void main(String[] args) {
        String senate = "RD";
        String ans = predictPartyVictory(senate);
        System.out.println(ans);
    }

    public static String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new ArrayDeque<>();
        Queue<Integer> dire = new ArrayDeque<>();

        for(int i =0; i < senate.length(); i++) {
            char c = senate.charAt(i);
            if(c == 'R') radiant.offer(i);
            else dire.offer(i);
        }
        System.out.println(radiant + " " + dire);

        while(!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();

            if(r < d) {
                radiant.offer(r + senate.length());
            }else {
                dire.offer(d + senate.length());
            }
        }

        if(dire.isEmpty()) return "Radiant";
        return "Dire";
    }
}
