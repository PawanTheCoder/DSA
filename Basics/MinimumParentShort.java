package Basics;

public class MinimumParentShort {
    public static void main(String[] args) {

        String s = "())";
        System.out.println(valid(s));
        
    }

    public static int valid(String s) {
        int open = 0;
        int close = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                open ++;
            }else {
                close ++;
            }
        }
        return Math.abs(open - close);
    }
    
}
