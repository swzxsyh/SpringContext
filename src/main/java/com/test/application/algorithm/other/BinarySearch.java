package com.test.application.algorithm.other;

/**
 * 二分法
 * <p>
 * 该方法需要数字顺序，否则结果会异常
 */
public class BinarySearch {


    /**
     * 查找比某个数字数小的最大数
     *
     * @return 数组下标
     */
    public int searchMin(int[] nums, int target) {
        // 定义左右指针
        int left = 0, right = nums.length - 1;
        // 当左指针小于等于右指针时，继续查找
        while (left <= right) {
            // 计算中间位置
            int mid = left + (right - left) / 2;
            // 如果中间位置的数大于等于目标数
            if (nums[mid] >= target) {
                // 将右指针移动到中间位置的左边
                right = mid - 1;
                // 如果中间位置的数小于目标数
            } else {
                // 将左指针移动到中间位置的右边
                left = mid + 1;
            }
        }
        // 返回比目标数小的最大数的下标
        return right;
    }

    /**
     * 查找比某个数字数大的最小数
     *
     * @return 数组下标
     */
    public int searchMax(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
