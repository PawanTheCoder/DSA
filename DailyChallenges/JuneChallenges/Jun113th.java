package DailyChallenges.JuneChallenges;

public class Jun113th {
    public static void main(String[] args) {
        
        String[] words = {"abcd","def","xyz"};
    int[] weights = {5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
     StringBuilder str = new StringBuilder();
     
        for(String word : words) {
            int sum =0;
            for(char c: word.toCharArray()) {
                 sum += weights[c - 'a'];
            }
            int num = 26 - (sum % 26);
            System.out.println(num);
            char letter = (char) ('a' + num - 1);
            str.append(letter);
        }
        System.out.println(str.toString());
    }
}
