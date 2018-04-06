package Singleton;

/**
 * Created by siyu on 5/2/2017.
 */
public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton(){}

    //it can cause issues if multiple threads are inside the if loop at the same time.
    // It will destroy the singleton pattern and both threads will get the different instances of singleton class.
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }

    //data access methods
}
