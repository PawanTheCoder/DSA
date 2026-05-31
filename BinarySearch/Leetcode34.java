package BinarySearch;

public class Leetcode34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] ansArr = searchRange(nums, 6);
        System.out.println(ansArr[0] + " " + ansArr[1]);
    }
    public static int[] searchRange(int[] nums, int target) {

    int[] invalid = {-1, -1};

    if(nums.length == 0) return invalid;

    int left = 0;
    int right = nums.length - 1;

    int foundIndex = -1;

    while(left <= right) {
        int mid = left + (right - left) / 2;

        if(nums[mid] == target) {
            foundIndex = mid;
            break;
        }
        else if(nums[mid] < target) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }

    if(foundIndex == -1) return invalid;

    int first = foundIndex;
    left = 0;
    right = foundIndex;

    while(left <= right) {
        int mid = left + (right - left) / 2;

        if(nums[mid] == target) {
            first = mid;
            right = mid - 1;   
        }
        else {
            left = mid + 1;
        }
    }

    // Find last occurrence
    int last = foundIndex;
    left = foundIndex;
    right = nums.length - 1;

    while(left <= right) {
        int mid = left + (right - left) / 2;

        if(nums[mid] == target) {
            last = mid;
            left = mid + 1;    // keep searching right
        }
        else {
            right = mid - 1;
        }
    }

    return new int[]{first, last};
}
}
