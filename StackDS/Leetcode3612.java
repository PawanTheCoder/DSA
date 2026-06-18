package StackDS;


public class Leetcode3612 {
    public static void main(String[] args) {
        String s = "p##";
        System.out.println(processStr(s));
    }

    public static String processStr(String s) {
        StringBuilder ans = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(c != '*' && c!= '#' && c != '%') {
                ans.append(c);
                continue;
            }
            if(c == '*' && !ans.isEmpty()) {
                ans.deleteCharAt(ans.length() - 1);
            }else if(c == '#' && !ans.isEmpty()) {
                ans.append(ans);
            }else if(c == '%'&& !ans.isEmpty()) {
                ans = ans.reverse();
            }
        }

        return ans.toString();
    }
}