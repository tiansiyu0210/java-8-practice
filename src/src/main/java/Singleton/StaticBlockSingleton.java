package Singleton;

/**
 * Created by siyu on 5/2/2017.
 */
public class StaticBlockSingleton {
    private static StaticBlockSingleton instance;

    private StaticBlockSingleton(){}

    //static block initialization for exception handling
    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");// static block that provides option for exception handling.
        }
        //perform additional steps
    }

    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}
