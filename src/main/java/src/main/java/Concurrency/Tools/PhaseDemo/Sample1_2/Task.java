package src.main.java.Concurrency.Tools.PhaseDemo.Sample1_2;


import java.sql.SQLOutput;
import java.util.concurrent.Phaser;

public class Task {

    private void task1(int i) {
        System.out.println("id : " + i + " doing the task 1");
    }

    private void task2(int i) {
        System.out.println("id : " + i + " doing the task 2");
    }

    private void task3(int i) {
        System.out.println("id : " + i + " doing the task 3");
    }


    public void performTask(Phaser phaser, int i){
        task1(i);
        phaser.arriveAndAwaitAdvance();
        task2(i);
        phaser.arriveAndAwaitAdvance();
        task3(i);
        phaser.arriveAndAwaitAdvance();
        System.out.println("out of the task i:" + i);
        phaser.arriveAndDeregister();
        System.out.println("deregister i: " + i);
    }

}
