package Singleton;

/**
 * Created by siyu on 5/2/2017.
 */
public class DoubleCheckedLockingSingleton {

    private static DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton(){}

    // To avoid this extra overhead every time,
    public static DoubleCheckedLockingSingleton getInstanceUsingDoubleLocking(){
        if(instance == null){
            synchronized (DoubleCheckedLockingSingleton.class) {
                if(instance == null){
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

}
