package com.test.application.algorithm.leetCode;

import java.util.Arrays;

/**
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * <p>
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 * <p>
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 * <p>
 * 返回规则如下：
 * <p>
 * 如果version1>version2返回1，
 * 如果version1<version2 返回 -1，
 * 除此之外返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/compare-version-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode165 {


    public static void main(String[] args) {
        String version1 = "1.01",version2 = "1.001";
//        String version1 = "1.0", version2 = "1.0.0";
//        String version1 = "0.1", version2 = "1.1";
//        String version1 = "1", version2 = "1.0";
//        String version1 = "1.05", version2 = "1.1";
        int result = new LeetCode165().compareVersion(version1, version2);
        System.out.println("result:" + result);
    }

    public int compareVersion(String version1, String version2) {
        String[] splitV1 = version1.split("\\.");
        String[] splitV2 = version2.split("\\.");

        if (splitV1.length == splitV2.length) {
            for (int i = 0; i < splitV1.length; i++) {
                if (Integer.parseInt(splitV1[i]) > Integer.parseInt(splitV2[i])) {
                    return 1;
                }
                if (Integer.parseInt(splitV1[i]) < Integer.parseInt(splitV2[i])) {
                    return -1;
                }
            }
            return 0;
        }


        int shortLength = Math.min(splitV1.length, splitV2.length);

        StringBuilder sbV1 = new StringBuilder();
        StringBuilder sbV2 = new StringBuilder();
        for (int i = 0; i < shortLength; i++) {
            sbV1.append(Integer.valueOf(splitV1[i]));
            sbV2.append(Integer.valueOf(splitV2[i]));
        }

        int result = sbV1.toString().compareTo(sbV2.toString());
        if (result == 0) {
            if (splitV1.length == shortLength) {
                for (int i = shortLength; i < splitV2.length; i++) {
                    if (Integer.parseInt(splitV2[i]) > 0) {
                        return -1;
                    }
                }
            }
            for (int i = shortLength; i < splitV1.length; i++) {
                if (Integer.parseInt(splitV1[i]) > 0) {
                    return 1;
                }
            }
        }
        return result;
    }
}
