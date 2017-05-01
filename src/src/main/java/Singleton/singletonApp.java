package Singleton;

/**
 * Created by siyu on 5/1/2017.
 */
public class singletonApp {
    public static void main(String[] args) {
        System.out.println("=======================Eager Initialized Singleton=================");
        EagerInitializedSingleton eagerInitializedSingleton = EagerInitializedSingleton.getInstance();
        eagerInitializedSingleton.add(50);
        eagerInitializedSingleton.remove(23);
        System.out.println(eagerInitializedSingleton.getQuantity());//50-23=27

        EagerInitializedSingleton eagerInitializedSingleton1 = EagerInitializedSingleton.getInstance();
        eagerInitializedSingleton1.add(100);
        System.out.println(eagerInitializedSingleton1.getQuantity());//27+100=127

    }
}
