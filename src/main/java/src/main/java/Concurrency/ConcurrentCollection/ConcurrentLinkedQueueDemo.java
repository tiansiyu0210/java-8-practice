package src.main.java.Concurrency.ConcurrentCollection;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
//https://blog.csdn.net/liyantianmin/article/details/50585641
//http://stackoverflow.com/questions/435069/java-util-concurrentlinkedqueue/435941
public class ConcurrentLinkedQueueDemo {

    public static void main(String[] args) {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.add(12);
        //peek， poll, add are atomic method they are thread-safe
        //but isEmpty, clear method are not thread-safe, so we need to add 'synchronized' to them
        //example:
        synchronized(queue) {
            if(!queue.isEmpty()) {
                queue.poll();
            }
        }
    }
}
