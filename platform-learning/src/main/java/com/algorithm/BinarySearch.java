package com.algorithm;

/**
 * @author zhangyongji
 * @since 2018/2/6.
 */
public class BinarySearch {
    /**
     * 基本的⼆分搜索
     *
     * @param nums
     * @param target
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int left_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public static int right_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                // 别返回，锁定右侧边界
                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] arr = {6, 7, 12, 33, 87, 90, 97, 108, 561};
        int[] nums = {6, 7, 7, 12, 33, 87, 90, 97, 108, 561};
        System.out.println(binarySearch(arr, 90));
        System.out.println(left_bound(nums,7));
        System.out.println(right_bound(nums,7));
    }
}


