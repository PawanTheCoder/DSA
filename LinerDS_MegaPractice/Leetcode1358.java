package LinerDS_MegaPractice;

public class Leetcode1358 {
    public static void main(String[] args) {
        String s = "abcabc";
        int ans = numberOfSubstrings(s);
        System.out.println(ans);
    }
    public static int numberOfSubstrings(String s) {
        int count =0;
        int left =0;
        int[] need = new int[3];
        for(int i =0; i < 3; i++) {
            need[i] = 1;
        }

        for(int num : need) {
            System.out.print(num + " ");
        }
        int required = 3;
        int  formed = 0;
        int[] window = new int[3];
        for(int right =0; right < s.length(); right ++) {
            char c = s.charAt(right);
            window[c - 'a'] ++;
            if(window[c - 'a'] > 0 && need[c - 'a'] == window[c-'a']) {
                formed ++;
            }
            while(required == formed) {
                System.out.println("Left : " + left + " Right : " + right);
                count += s.length() - right;
                char d = s.charAt(left);
                window[d - 'a']--;
                if(window[d - 'a'] == 0) {
                    formed--;
                }
                left ++;
            }
        }
        return count;
    }
}