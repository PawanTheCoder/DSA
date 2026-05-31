package GreedyAlgorithms.TwoPointersGreedy;

public class Leetcode125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean isValid = isPalindrome(s);
        System.out.println(isValid);
    }
    public static boolean isPalindrome(String s) {
        // First we have to remove all the characters which are not alpha numeric
        if(s.length() <= 0) return false;
        StringBuilder palindromeString = new StringBuilder();
        for(int i =0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            int ascii = (int) c;
            if( ascii >= 65 && ascii <= 90) {
                char alternativeCaps = (char) (ascii + 32);
                palindromeString.append(alternativeCaps);
            }if(ascii >= 97 && ascii <= 122 || ascii >= 48 && ascii <=57) {
                palindromeString.append(c);
            }
        }
        System.out.println(palindromeString);

        int i = 0;
        int j = palindromeString.length() - 1;
        while( i <= j) {
            if(palindromeString.charAt(i) == palindromeString.charAt(j)) {
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}