package com.test.application.algorithm.other;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.*;
import org.junit.Test;

@Slf4j
public class JumpStepsTest {

    @Test
    public void jump() {
        final int jump = new JumpSteps().jump(5);
        log.info("jump result :{}", jump);

        int result = new JumpSteps().calculate(177);
        log.info("jump result :{}", result);
    }


    @Test
    public void test() {
        int fullSteps = 5;
        int calculate = calculate(fullSteps);
        System.out.println("result: " + calculate);
        fullSteps = 177;
        calculate = calculate(fullSteps);
        System.out.println("result: " + calculate);

        final int calculate1 = calculate(5, new int[]{2, 3});
        System.out.println(calculate1);
    }

    private int calculate(int fullSteps) {
        int count = fullSteps / 3;

        int remainStep = fullSteps - count * 3;

        if (remainStep > 0) {
            int i = remainStep / 2;
            count = count + i;

            remainStep = remainStep - 2 * i;

            if (remainStep > 0) {
                return -1;
            }
        }
        return count;
    }

    private int calculate(int fullSteps, int[] steps) {
        int count = fullSteps / steps[1];
        int remainStep = fullSteps % steps[1];

        if (remainStep > 0) {
            int i = remainStep / steps[0];
            count += i;
            remainStep = remainStep % steps[0];
            if (remainStep > 0) {
                return -1;
            }
        }
        return count;
    }
}