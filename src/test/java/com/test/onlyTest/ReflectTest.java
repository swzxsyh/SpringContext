package com.test.onlyTest;

import com.test.infrastructure.model.entity.IdentityEntity;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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


    /**
     * 如果使用内部类，反射类名前为$符。内部类反射后，调用newInstance方法目前异常，需修复
     */
    @Test
    public void twoReflectWayTest() {
        try {
            Class<?> reflectEntity = Class.forName("com.test.infrastructure.model.entity.IdentityEntity");
            final Method sMethod = reflectEntity.getMethod("setName", String.class);
            final Object o = reflectEntity.newInstance();
            sMethod.invoke(o, "abc");
            System.out.println(o);
        } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        final Class<IdentityEntity> IdentityEntityClass = IdentityEntity.class;
        try {
            final IdentityEntity identityEntity = IdentityEntityClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
