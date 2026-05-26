package Basics;

public class LongestParenth { 
    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(Solution(s));
    }
    public static int Solution(String s ) {
       int open = 0;
       int count = 0;
       int max = 0;

       for(char c : s.toCharArray()) {
        if(c == '(' && open == 0) {
            open ++;
            continue;
        } 
        if(c == ')' && open == 1) {
            open --;
            count ++;
            continue;
        }
        if(c == '(' && open == 1) {
            max = Math.max(count , max);
            count = 0;
            continue;
        }
        if(c == ')' && open == 0) {
            max = Math.max(count , max);
            count = 0;
        }
       }
       max = Math.max(count , max);
       return max * 2;
    }
}
