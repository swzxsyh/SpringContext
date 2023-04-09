package com.test.application.algorithm.other;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TournamentSearch {


    public int getLightestBall(int[] balls) {
        return compare(balls, 0, balls.length - 1);
    }

    private int compare(int[] array, int start, int end) {
        // 当前比较区间只有一个元素时，直接返回该元素
        if (start == end) {
            return array[start];
        }

        // 将当前比较区间分为两个子区间，分别进行递归比较
        int mid = (start + end) / 2;
        // 比较左子区间
        int leftLightest = compare(array, start, mid);
        // 比较右子区间
        int rightLightest = compare(array, mid + 1, end);

        // 比较左右子区间的最轻元素，返回最轻元素
        return Math.min(leftLightest, rightLightest);
    }
}
