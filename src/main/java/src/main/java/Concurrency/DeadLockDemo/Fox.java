package src.main.java.Concurrency.DeadLockDemo;

public class Fox {

    public void eatAndDrink(Food food, Water water){
        synchronized (food){
            System.out.println("got food first");
            move();
            synchronized (water){
                System.out.println("got water second");
            }
        }
    }

    public void drinkAndEat(Food food, Water water){
        synchronized (water){
            System.out.println("got water first");
            move();
            synchronized (food){
                System.out.println("got food second");
            }
        }
    }

    public void move(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
