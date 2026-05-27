package MonotonicStack;

import java.util.ArrayList;
import java.util.HashSet;

public class Leetcode3121 {

    public static void main(String[] args) {

        String word = "eBbBaCdc";

        int result = numberOfSpecialChars(word);

        System.out.println(result);
    }

    public static int numberOfSpecialChars(String word) {

        HashSet<Integer> smallWords = new HashSet<>(word.length());

        ArrayList<Integer> wordArrayList = new ArrayList<>(word.length());

        ArrayList<Integer> smalls = new ArrayList<>(word.length());

        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);

            int ascii = (int) c;

            // lowercase letters
            if (ascii >= 97 && ascii <= 122) {

                smallWords.add(ascii);
            }

            wordArrayList.add(ascii);
        }

        for (int n : smallWords) {

            smalls.add(n);
        }

        int ans = 0;

        for (int i = 0; i < smalls.size(); i++) {

            boolean isValid = false;

            boolean isFound = false;

            boolean upperFound = false;

            for (int j = 0; j < wordArrayList.size(); j++) {

                // lowercase found
                if (smalls.get(i).equals(wordArrayList.get(j))) {

                    // lowercase appears again after uppercase
                    if (upperFound) {

                        isFound = false;

                        break;
                    }

                    isValid = true;
                }

                // uppercase found after lowercase
                if (smalls.get(i) - wordArrayList.get(j) == 32 && isValid) {

                    upperFound = true;

                    isFound = true;
                }
            }

            if (isFound) {

                ans++;
            }
        }

        return ans;
    }
}