package MonotonicStack;

import java.util.ArrayList;

public class Leetcode3120 {
    public static void main(String[] args) {
        String word = "BBbab";
        int ans = 0;
        ArrayList<Integer> capitals = new ArrayList<>(word.length());
        ArrayList<Integer> words = new ArrayList<>(word.length());
        for(int i = 0 ; i <word.length() ; i ++ )   {
            char c = word.charAt(i);
            int ascii = (int) c;
            words.add(ascii);

            if(ascii >= 65 && ascii <= 90) {
                capitals.add(ascii);
            }
            
        }

        for(int i = 0 ; i < words.size() ; i++) {
            for(int j = i + 1; j <words.size() ; j ++) {
               if(words.get(j) >= 97 && words.get(j) <=122) {
                 if(words.get(i) == words.get(j)) {
                    words.remove(j);
                }
               }
            }
        }

        for(int i = 0 ; i < capitals.size() ; i++) {
            for(int j = 0 ; j < words.size() ; j++) {
                int result = Math.abs(capitals.get(i) - words.get(j));
                if(result == 32){
                    ans ++;
                    capitals.remove(i);
                    words.remove(j);
                    i--;
                    break;
                }
            }
        }
        
        System.out.println(ans);
    }
}
