package src.main.java.Concurrency.Tools.CyclicBarrierDemo;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        CyclicBarrier playersCounter = new CyclicBarrier(10, new Runnable() {
            //() -> System.out.println("所有玩家准备就绪，开始游戏！")
            @Override
            public void run() {
                System.out.println("所有玩家准备就绪，开始游戏！");
            }
        });
        System.out.println("等待玩家加入游戏");

        for (int i=0;i<20;i++){
            executorService.execute(new Player(playersCounter,i+""));
        }

        playersCounter.isBroken();

    }
}