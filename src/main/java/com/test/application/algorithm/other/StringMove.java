package com.test.application.algorithm.other;

/**
 * 给定一个字符串，这个字符串为*号和26个字母的任意组合。现在需要把字符串的*号都移动到最左侧，而把字符串中的字母移动到最右侧并保持相对顺序不变，要求时间复杂度和空间复杂度最小。
 */
public class StringMove {

    public String sortOrder(String str) {
        String s = str.replace("*", "");
        int len = str.length() - s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append("*");
        }
        return sb.append(s).toString();
    }
}
