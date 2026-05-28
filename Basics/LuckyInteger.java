package Basics;

public class LuckyInteger {
    public static void main(String[] args) {
        int[] arr = {2,2,3,4};
        int ans = findLucky(arr);
        System.out.println(ans);
    }
    public static int findLucky(int[] arr) {
       int[] frequency = new int[501];
       for(int num : arr) {
        frequency[num] += 1;
       }

       for(int i =frequency.length -1 ; i >=0 ; i --) {
        if(frequency[i] == i) {
            return i;
        }
       }
    return -1;
    }
}
