package src.main.java.Concurrency.Tools.CyclicBarrierDemo;

import java.util.concurrent.CyclicBarrier;
//http://moon-walker.iteye.com/blog/2407828
class Player implements Runnable{
    private CyclicBarrier playersCounter;
    private String name;

    public Player(CyclicBarrier playersCounter,String name) {
        this.playersCounter = playersCounter;
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("玩家："+name+"加入游戏");
        try {
            Thread.sleep(1000);
            playersCounter.await();
            System.out.println("玩家："+name+"开始选英雄");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}