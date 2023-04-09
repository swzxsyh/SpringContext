package com.test.application.algorithm.other;

import lombok.extern.slf4j.Slf4j;

/**
 * 想象 0 到 n-1 个人围成一个圈，每个人中的距离是相等的，试求出第 firstNumber 号对面的人是几号
 * <p>
 * 输入：n = 10, firstNumber = 2
 * 输出：7
 * 解释：此例中 n=10, firstNumber=2 时，正对面的人为 7 号，因此你的程序应输出 7
 */
@Slf4j
public class JosephusRing {

    public int oppositePerson(int n, int firstNumber) {
        return (firstNumber + n / 2) % n;
    }
}
