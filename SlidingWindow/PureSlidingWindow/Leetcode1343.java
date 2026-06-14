package SlidingWindow.PureSlidingWindow;

public class Leetcode1343 {
    public static void main(String[] args) {
        int[] nums = {11,13,17,23,29,31,7,5,2,3};
        int k = 3;
        int threshold = 5;

        int ans = numOfSubarrays(nums, k, threshold);
        System.out.println(ans);
    }

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans =0;
        int left =0;
        int currrentSum = 0;
        for(int right =0; right <arr.length ; right ++) {
            currrentSum += arr[right];

            if(right - left + 1 > k) {
                currrentSum -= arr[left];
                left ++;
            }
            if(right - left + 1 == k) {
                int avg = currrentSum / k;
                if(avg >= threshold) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
