package Singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by siyu on 5/2/2017.
 */
public class SerializedSingleton implements Serializable{

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton(){}

    private static class SingletonHelper{
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance(){
        return SingletonHelper.instance;
    }

    protected Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}
