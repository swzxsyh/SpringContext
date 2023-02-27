package com.test.onlyTest;

import org.junit.Test;

import java.lang.reflect.Field;

public class ReflectTest {

    /**
     * 测试String是否可以被修改
     * String被final修饰，且内部为final char[],但Array并不能保证不被修改，因此可以通过反射变更
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void modifyStringTest() throws NoSuchFieldException, IllegalAccessException {
        String s = "123";
        Field valueArray = String.class.getDeclaredField("value");
        valueArray.setAccessible(true);
        char[] array = (char[]) valueArray.get(s);
        array[0] = '2';
        System.out.println(s);//223
    }
}
