package com.test.onlyTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

@Slf4j
public class BaseStructureTest {

    /**
     * 测试float是否为0
     */
    @Test
    public void floatTest() {
        float a = 0.0000000f;
        if (a != 0.0) {
            log.info("Y");
        }

        if (a < 1e-6) {
            log.info("Zero");
        }

        if (a == 0) {
            log.info("result:{}", Boolean.TRUE);
            return;
        }
        log.info("result:{}", Boolean.FALSE);
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
        log.info("a:{}", a);
        log.info("b:{}", b);
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
        log.info("a: {}", a);
        log.info("b: {}", b);
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
        log.info("tableSizeFor 1000 result: {}", result_1K);
        log.info("tableSizeFor 10000 result: {}", result_1W + "\n");

        int finalSize_1K = (int) (result_1K * loadFactor);
        int finalSize_1W = (int) (result_1W * loadFactor);

        log.info("finalSize 1000 result: {}", finalSize_1K);
        log.info("finalSize 10000 result: {}", finalSize_1W);
    }

    /**
     * 异或操作
     */
    @Test
    public void xorTest() {

        //异或满足交换律和结合律，因此对一个数异或异或两次没有异或
        int x = 1, y = 5;
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        log.info("x: {},y: {}", x, y);
        //异或是一种按位逻辑韵味，规则为：两个二进制位相同则结果为0，不同则为1
        x = x ^ x;
        log.info("x: " + x);

    }

    /**
     * Pv4转数字，只能用int类型
     */
    @Test
    public void ipv4ToIntTest() {
        String ipAddr = "192.168.50.236";
        String[] ip = ipAddr.split("\\.");
        int result = (Integer.parseInt(ip[0]) << 24) | (Integer.parseInt(ip[1]) << 16) |
                (Integer.parseInt(ip[2]) << 8) | Integer.parseInt(ip[3]);
        log.info("result: {}", result);
    }

    @Test
    public void unInitStringTest() {
        //java: variable source might not have been initialized
        //String source;
        String source = "abc";
        log.info("source: {}", source);
    }

    /**
     * 字符串测试，String最好不用==比较，容易出现常量池比较堆数据问题，即使字符串相同，地址却并不同，导致不相等
     * compareTo() 比较ASCII码，相等返回 0，前比后小 <0 ,前比后大 >0
     */
    @Test
    public void equalsTest() {
        //堆
        String s1 = new String("abc");
        //常量池
        String s2 = "abc";
        //常量池，大概是优化，生成的内容进入常量池
        String s3 = "ab" + "c";
        //常量池
        String s4 = "abc";
        //堆, 通过char[]生成新对象
        String s5 = "ab".concat("c");

        log.info("s1.compareTo(s3) result: {}", s1.compareTo(s3));

        log.info("s1 == s2 result: {}", s1 == s2);
        log.info("s1 equals s2 result: {}", s1.equals(s2));
        log.info("s2 == s3 result: {}", s2 == s3);

        log.info("s2 == s4 result: {}", s2 == s4);

        log.info("s1 == s3 result: {}", s1 == s3);

        log.info("s2 == s5 result: {}", s2 == s5);
    }
}
