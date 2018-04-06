package Singleton;

import java.io.*;

/**
 * Created by siyu on 5/1/2017.
 */
public class singletonApp {
    public static void main(String[] args) {
        System.out.println("=======================Eager Initialized Singleton=================");
        EagerInitializedSingleton eagerInitializedSingleton = EagerInitializedSingleton.getInstance();
        eagerInitializedSingleton.add(50);
        try {
            eagerInitializedSingleton.remove(23);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(eagerInitializedSingleton.getQuantity());//50-23=27

        EagerInitializedSingleton eagerInitializedSingleton1 = EagerInitializedSingleton.getInstance();
        eagerInitializedSingleton1.add(100);
        System.out.println(eagerInitializedSingleton1.getQuantity());//27+100=127


        System.out.println("=======================Serialized Singleton=================");

        SerializedSingleton INSTANCE = SerializedSingleton.getInstance();
        try{
            SerializedSingleton instanceOne = SerializedSingleton.getInstance();
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
            out.writeObject(instanceOne);
            out.close();

            //deserailize from file to object
            ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
            SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
            in.close();

            System.out.println("instanceOne hashCode="+instanceOne.hashCode());
            System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
