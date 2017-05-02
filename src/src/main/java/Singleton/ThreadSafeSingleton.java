package Singleton;

/**
 * Created by siyu on 5/2/2017.
 */
//this implementation works fine and provides thread-safety
// but it reduces the performance because of cost associated with the synchronized method
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}

    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

}
