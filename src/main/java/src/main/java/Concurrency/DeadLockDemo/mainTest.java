package src.main.java.Concurrency.DeadLockDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class mainTest {
    public static void main(String[] args) {
        Fox fox1 = new Fox();
        Fox fox2 = new Fox();

        Water water = new Water();
        Food food = new Food();

        Water water1 = new Water();
        Food food1 = new Food();

        ExecutorService executorService = null;

        try{
            executorService = Executors.newScheduledThreadPool(10);
            executorService.submit(()-> fox1.eatAndDrink(food, water));
            executorService.submit(()-> fox2.drinkAndEat(food,water));
        }finally {
            if(executorService != null){
                executorService.shutdown();
            }
        }
    }

}
