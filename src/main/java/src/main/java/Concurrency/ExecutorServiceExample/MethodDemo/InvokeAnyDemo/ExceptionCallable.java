package src.main.java.Concurrency.ExecutorServiceExample.MethodDemo.InvokeAnyDemo;


import java.util.concurrent.Callable;
//这是一个可能会在执行过程中，抛出空指针异常的任务。
public class ExceptionCallable implements Callable<String> {

    private String name = null;

    public ExceptionCallable()
    {

    }

    public ExceptionCallable(String name)
    {
        this.name = name;
    }

    @Override
    public String call() throws Exception
    {
        System.out.println("begin to ExceptionCallable.");

        System.out.println(name.length());

        System.out.println("end to ExceptionCallable.");

        return name;
    }

}

