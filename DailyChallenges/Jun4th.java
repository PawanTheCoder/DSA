package DailyChallenges;

import java.util.ArrayList;
import java.util.Collections;

public class Jun4th {
    public static void main(String[] args) {
        int num1 = 120;
        int num2 = 190;
        System.out.println(totalWaviness(num1, num2));
    }

    public static int totalWaviness(int num1, int num2) {
        int total = 0;
        for(int i =num1 ; i <=num2 ; i++) {
            int number = i;
            ArrayList<Integer> arr = new ArrayList<>();
            while(number != 0) {
                arr.add(number % 10);
                number /= 10;
            }
            Collections.reverse(arr);

            for(int num : arr) {
                System.out.print(num);
            }
            System.out.println();
            for(int j = 1; j <= arr.size() -2 ; j++) {
                if(arr.get(j) > arr.get(j - 1) && arr.get(j) > arr.get(j + 1)) {
                    total += 1;
                }else if(arr.get(j) < arr.get(j -1) && arr.get(j) < arr.get(j + 1)) {
                    total += 1;
                }
            }
        }
        return total;
    }
}
