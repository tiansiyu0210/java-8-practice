package src.main.java.Concurrency.Tools.PhaseDemo.Sample1_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class phaserTest1_2 {



    public static void main(String[] args) {
        Phaser phaser = new Phaser(5);
        ExecutorService service = Executors.newFixedThreadPool(5);
        Task task = new Task();
        for(int i = 1; i <= 5 ; i++){
            int id = i;
            service.submit(()-> task.performTask(phaser, id));
        }
    }
}
