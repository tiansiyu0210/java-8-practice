package src.main.java.Concurrency.ExecutorServiceExample.MethodDemo.InvokeAnyDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
//这是一个通过睡眠来模拟的耗时任务，该任务是可中断/可终止的任务，能够响应中断请求
public class SleepSecondsCallable implements Callable<String> {
    private String name;

    private int seconds;

    public SleepSecondsCallable(String name, int seconds)
    {
        this.name = name;
        this.seconds = seconds;
    }

    public String call() throws Exception
    {
        System.out.println(name + ",begin to execute");

        try
        {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e)
        {
            System.out.println(name + " was disturbed during sleeping.");
            e.printStackTrace();
            return name + "_SleepSecondsCallable_failed";
        }

        System.out.println(name + ",success to execute");

        return name + "_SleepSecondsCallable_succes";
    }

}

