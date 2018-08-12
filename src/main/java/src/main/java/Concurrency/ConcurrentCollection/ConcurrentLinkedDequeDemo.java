package src.main.java.Concurrency.ConcurrentCollection;

import java.util.concurrent.ConcurrentLinkedDeque;

//https://segmentfault.com/a/1190000013144544
//该程序实现了多线程并发添加大量元素到一个公共的链表，刚好是ConcurrentLinkedDeque的典型使用场景。
// 同时也验证了上面的说法，即size()方法需要遍历链表，可能返回错误的结果。
public class ConcurrentLinkedDequeDemo {
    private static ConcurrentLinkedDeque<String> cld = new ConcurrentLinkedDeque<>();

    public static void main(String[] args) {
        int numThread = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[numThread];
        for (int i = 0; i < threads.length; i++) {
            (threads[i] = new Thread(addTask(), "Thread "+i)).start();
        }
    }

    public static Runnable addTask() {
        return new Runnable() {

            @Override
            public void run() {
                int num = Runtime.getRuntime().availableProcessors();
                for (int i = 0; i < num; i++) {
                    StringBuilder item = new StringBuilder("Item ").append(i);
                    cld.addFirst(item.toString());
                    callbackAdd(Thread.currentThread().getName(), item);
                }
                callbackFinish(Thread.currentThread().getName());
            }
        };
    }

    public static void callbackAdd(String threadName, StringBuilder item) {
        StringBuilder builder = new StringBuilder(threadName).append(" added :").append(item);
        System.out.println(builder);
    }

    public static void callbackFinish(String threadName) {
        StringBuilder builder = new StringBuilder(threadName).append(" has Finished");
        System.out.println(builder);
        System.out.println(new StringBuilder("CurrentSize ").append(cld.size()));
    }
}
