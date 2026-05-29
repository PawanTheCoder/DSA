package Basics;
import java.util.*;

public class LongestPrefixString {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String ans = longestCommonPrefix(strs);
        System.out.println(ans);
    }

    public static String longestCommonPrefix(String[] strs) {
        ArrayList<Character> arr = new ArrayList<>();
        int smallestLength = Integer.MAX_VALUE;
        int smallestStringIndex = 0;
        for(int i =0 ; i < strs.length ; i++) {
            smallestLength = Math.min(smallestLength , strs[i].length());
        }

        for(int i = 0 ; i < strs.length ; i++) {
            if(smallestLength == strs[i].length()) {
                smallestStringIndex = i;
            }
        }
        String smallestString = strs[smallestStringIndex];
        System.out.println(smallestString);

        for(int i =0 ; i < smallestString.length() ; i++) {
            char c = smallestString.charAt(i);
            arr.add(c);
        }

        for(int i =0 ; i < strs.length ; i++) {
            String str = strs[i];
            for(int j = 0 ; j <arr.size() ; j++) {
              char c = str.charAt(j);
              if(c != arr.get(j)) {
                while(arr.size() > j) {
    arr.remove(arr.size() - 1);
}
                break;
              }  
            }
        }
        StringBuilder finalString = new StringBuilder();
        for(int i =0 ;i < arr.size() ; i++) {
            finalString.append(arr.get(i));
        }
        return finalString.toString();
    }
}
