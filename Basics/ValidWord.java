package Basics;

public class ValidWord {
    public static void main(String[] args) {
        String str = "234Aa";
        boolean ans = isValid(str);
        System.out.println(ans);
    }
     public static boolean isValid(String word) {
        if(word.length() <3) return false;
        boolean doesContainVowel = false;
        boolean doesContainConsonant = false;
        for(int i = 0 ; i < word.length() ; i++) {
            char c = word.charAt(i);
            int ascii = (int) c;
            if(c == 'a' || c == 'e' || c== 'i' || c == 'o' || c =='u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                doesContainVowel = true;
                continue;
            }
            if(ascii>= 48 && ascii <=57) {
                continue;
            }if((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122)) {
                doesContainConsonant = true;
            }else {
                return false;
            }
        }
        if(doesContainVowel == true && doesContainConsonant  == true) {
            return true;
        }else {
            return false;
        }
    }
}
