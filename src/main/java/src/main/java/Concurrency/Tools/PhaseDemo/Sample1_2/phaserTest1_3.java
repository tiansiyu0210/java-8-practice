package src.main.java.Concurrency.Tools.PhaseDemo.Sample1_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class phaserTest1_3 {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(5){
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                boolean a = true;
                if(phase == 0){
                    System.out.println("=====" + " stop 1 " + "======" + "registeredParties: " + registeredParties);
                    if( registeredParties == 5){
                        System.out.println("5 thread arrived stop 1");
                    }
                    a = false;
                }else if(phase == 1){
                    System.out.println("=====" + " stop 2 " + "======" + "registeredParties: " + registeredParties);
                    if( registeredParties == 5){
                        System.out.println("5 thread arrived stop 2");
                    }
                    a = false;
                }else if(phase == 2){
                    System.out.println("=====" + " stop 3 " + "======" + "registeredParties: " + registeredParties);
                    if( registeredParties == 5){
                        System.out.println("5 thread arrived stop 3");
                    }
                }
                return a;
            }
        };

        Task task = new Task();
        ExecutorService service = Executors.newFixedThreadPool(5);
        for(int i = 1; i<=5; i++){
            int id = i;
            service.submit(()->task.performTask(phaser, id));
        }

        phaser.register();
        while (!phaser.isTerminated()) {
            System.out.println("!!!!!  in the main thread" );
            phaser.arriveAndAwaitAdvance();
        }
        System.out.println("done");
    }
}
