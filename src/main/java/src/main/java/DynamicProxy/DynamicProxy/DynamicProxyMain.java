package src.main.java.DynamicProxy.DynamicProxy;

import src.main.java.DynamicProxy.Proxy.Interface;
import src.main.java.DynamicProxy.Proxy.RealObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyMain {

    public static void main(String[] args) throws Throwable {

        RealObject realObject = new RealObject();
        consumer(realObject);
        System.out.println("==============================");

        //Dynamic Proxy
        ClassLoader classLoader = Interface.class.getClassLoader();
        Class<?>[] interfaces = new Class[] { Interface.class };
        InvocationHandler handler = new DynamicProxyHandler(realObject);

        Interface proxy = (Interface) Proxy.newProxyInstance(classLoader, interfaces, handler);
        System.out.println("in DynamicProxyMain proxy: " + proxy.getClass());
        consumer(proxy);
        System.out.println("!!!!!!!!!!!!!!!!!!!");
        if (proxy instanceof Proxy) {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(proxy);
            invocationHandler.invoke(proxy, realObject.getClass().getMethod("getMyName"), null);
            System.out.println("--------------------------------------");
        }
    }


    public static void consumer(Interface iface) {
        iface.getMyName();
        String name = iface.getNameById("1");
        System.out.println("name: " + name);

    }
}
