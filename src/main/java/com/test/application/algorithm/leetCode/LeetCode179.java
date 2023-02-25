package com.test.application.algorithm.leetCode;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class LeetCode179 {

    public static void main(String[] args) {
//        int[] nums = {10, 2};
        int[] nums = {3, 30, 34, 5, 9};

        String result = new LeetCode179().largestNumber(nums);

        System.out.println("result: " + result);
    }

    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(nums).boxed().map(String::valueOf).sorted((o1, o2) -> {
            String str1 = o1 + o2;
            String str2 = o2 + o1;

            return str2.compareTo(str1);
        }).map(sb::append).collect(Collectors.joining());

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
