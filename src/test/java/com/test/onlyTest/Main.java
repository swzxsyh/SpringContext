package com.test.onlyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Proxy Test
 * <p>
 * JDK Proxy can only Proxy Interface, CGLIB can Proxy Classes and Interface
 * Reason: Maybe only extend Proxy can be less complicate
 * <p>
 * JDK Proxy generate a new Class extend Proxy Class, Keep Both Original Class and Proxy Class
 * CGLIB Proxy replace Class, only have Proxy Class
 */
public class Main {
    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        MyInterface myInterface = (MyInterface) Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                new Class<?>[]{MyInterface.class},
                new MyInvocationHandler());

        System.out.println(myInterface.getClass().getSuperclass().getName());
        System.out.println(myInterface.getClass().getName());

        CglibProxy cglibProxy = new CglibProxy();
        MyClass myClass = cglibProxy.getProxy(MyClass.class);
        System.out.println(myClass.getClass().getSuperclass().getName());
        System.out.println(myClass.getClass().getName());
    }
}

interface MyInterface {
    void doSomething();
}

class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoking method: " + method.getName());
        return null;
    }
}

class MyClass {
    public void doSomething() {
        System.out.println("Doing something");
    }
}

class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public <T> T getProxy(Class<T> clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before method: " + method.getName());
        Object result = methodProxy.invokeSuper(o, args);
        System.out.println("After method: " + method.getName());
        return result;
    }
}
