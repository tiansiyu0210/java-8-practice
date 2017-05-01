package Singleton;

/**
 * Created by siyu on 5/1/2017.
 */

/* this method doesn’t provide any options for exception handling. */
public class EagerInitializedSingleton{
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    //private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton(){}

    private int quantity = 0;

    public static EagerInitializedSingleton getInstance(){
        return instance;
    }

    public synchronized void add(int amount){

        quantity += amount;
    }

    public synchronized void remove(int amount){
        if(quantity < amount){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
        quantity -= amount;
    }

    public synchronized int getQuantity() {
        return quantity;
    }
}
