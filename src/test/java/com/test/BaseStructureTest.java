package com.test;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class BaseStructureTest {

    /**
     * 测试float是否为0
     */
    @Test
    public void floatTest() {
        float a = 0.0000000f;
        if (a != 0.0) {
            System.out.println("Y");
        }

        if (a < 1e-6) {
            System.out.println("Zero");
        }

        if (a == 0) {
            System.out.println(Boolean.TRUE);
            return;
        }
        System.out.println(Boolean.FALSE);
    }

    /**
     * 通过^对调数值
     */
    @Test
    public void swapTest() {
        int a = 10;
        int b = 20;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a:" + a);
        System.out.println("b:" + b);
    }

    /**
     * 通过普通方法对调数值
     */
    @Test
    public void swapABTest() {
        int a = 10;
        int b = 20;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a);
        System.out.println(b);
    }

    /**
     * HashMap扩容数值测试，最后生成数值测试（x^2*0.75）
     * <p>
     * 当前方法存在命名不规范问题
     *
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void tableSizeFor() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final double loadFactor = 0.75;
        final int cap_1K = 1000;
        final int cap_1W = 10000;

        Method tableSizeFor = HashMap.class.getDeclaredMethod("tableSizeFor", int.class);
        tableSizeFor.setAccessible(Boolean.TRUE);
        int result_1K = (int) tableSizeFor.invoke(null, cap_1K);
        int result_1W = (int) tableSizeFor.invoke(null, cap_1W);
        System.out.println("tableSizeFor 1000 result: " + result_1K);
        System.out.println("tableSizeFor 10000 result: " + result_1W + "\n");

        int finalSize_1K = (int) (result_1K * loadFactor);
        int finalSize_1W = (int) (result_1W * loadFactor);

        System.out.println("finalSize 1000 result: " + finalSize_1K);
        System.out.println("finalSize 10000 result: " + finalSize_1W);
    }


}
