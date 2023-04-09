package com.test.application.algorithm.other;

/**
 * 兔子跳下台阶，一次只能跳2阶台阶或3阶台阶，n个台阶至少要跳几次能跳下去，如果跳不下去返回-1
 */
public class JumpSteps {

    public int jump(int n) {
        if (n == 2 || n == 3) {
            return 1;
        } else if (n < 2) {
            return -1;
        } else {
            int twoSteps = jump(n - 2);
            int threeSteps = jump(n - 3);
            if (twoSteps == -1 && threeSteps == -1) {
                return -1;
            } else if (twoSteps == -1) {
                return threeSteps + 1;
            } else if (threeSteps == -1) {
                return twoSteps + 1;
            } else {
                return Math.min(twoSteps, threeSteps) + 1;
            }
        }
    }

    public int calculate(int fullSteps) {
        if (fullSteps < 2) {
            return -1; // Impossible to traverse the staircase
        }

        int[] dp = new int[fullSteps + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= fullSteps; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (i - 2 >= 0) {
                dp[i] = Math.min(dp[i], dp[i-2] + 1);
            }
            if (i - 3 >= 0) {
                dp[i] = Math.min(dp[i], dp[i-3] + 1);
            }
        }

        if (dp[fullSteps] == Integer.MAX_VALUE) {
            return -1; // Impossible to traverse the staircase
        } else {
            return dp[fullSteps];
        }
    }

}
