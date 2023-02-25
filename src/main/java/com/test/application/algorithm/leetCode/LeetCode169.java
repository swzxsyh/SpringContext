package com.test.application.algorithm.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode169 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
//        int[] nums = {2,2,1,1,1,2,2};
        int result = new LeetCode169().majorityElement(nums);
        System.out.println("result:" + result);
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer currentNum = map.get(num);
            if (currentNum == null) {
                map.put(num, 1);
                continue;
            }
            map.put(num, currentNum + 1);
        }
        int maxCount = 0;
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = entry.getKey();
            }
        }
        System.out.println(result);
        if(maxCount < nums.length/2){
            return 0;
        }

        return result;
    }
}
