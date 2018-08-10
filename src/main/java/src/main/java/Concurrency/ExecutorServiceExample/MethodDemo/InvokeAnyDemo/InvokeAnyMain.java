package src.main.java.Concurrency.ExecutorServiceExample.MethodDemo.InvokeAnyDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class InvokeAnyMain {
    public static void main(String[] args) {

    }



    /**
     * 提交的任务集合,一旦有1个任务正常完成(没有抛出异常),会终止其他未完成的任务
     */
    public static void invokeAny1() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = new ArrayList<Callable<String>>();

        //第一种情况，向线程池提交2个耗时任务SleepSecondsCallable
        tasks.add(new SleepSecondsCallable("t1", 2));
        tasks.add(new SleepSecondsCallable("t2", 1));

        String result = executorService.invokeAny(tasks);

        System.out.println("result=" + result);

        executorService.shutdown();
    }



    /**
     * 没有1个正常完成的任务,invokeAny()方法抛出ExecutionException,封装了任务中元素的异常
     *
     */

    //如果提交的任务列表中，没有1个正常完成的任务，那么调用invokeAny会抛异常，究竟抛的是哪儿个任务的异常，无关紧要。
    public static void invokeAny2() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = new ArrayList<Callable<String>>();

        //第二种情况，向线程池提交3个异常任务ExceptionCallable
        tasks.add(new ExceptionCallable());
        tasks.add(new ExceptionCallable());
        tasks.add(new ExceptionCallable());

        String result = executorService.invokeAny(tasks);

        System.out.println("result=" + result);

        executorService.shutdown();
    }



    /**
     * 有异常的任务,有正常的任务,invokeAny()不会抛异常,返回最先正常完成的任务
     */
    public static void invokeAny3() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = new ArrayList<Callable<String>>();

        tasks.add(new ExceptionCallable());
        tasks.add(new ExceptionCallable());
        tasks.add(new ExceptionCallable());
        tasks.add(new ExceptionCallable());

        tasks.add(new SleepSecondsCallable("t1", 2));

        String result = executorService.invokeAny(tasks);

        System.out.println("result=" + result);
        executorService.shutdown();
    }



    /**
     * 还没有到超时之前,所以的任务都已经异常完成,抛出ExecutionException<br>
     * 如果超时前满,还没有没有完成的任务,抛TimeoutException
     */
    public static void invokeAnyTimeout() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = new ArrayList<Callable<String>>();

        tasks.add(new ExceptionCallable());
        tasks.add(new ExceptionCallable());
        tasks.add(new ExceptionCallable());
        tasks.add(new ExceptionCallable());

        String result = executorService.invokeAny(tasks, 2, TimeUnit.SECONDS);

        System.out.println("result=" + result);

        executorService.shutdown();
    }


}
