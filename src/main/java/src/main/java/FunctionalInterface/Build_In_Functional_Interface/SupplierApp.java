/**
 * Created by stian on 4/6/18.
 */
package src.main.java.FunctionalInterface.Build_In_Functional_Interface;

import src.main.java.Beans.Person;

import java.util.Date;
import java.util.function.Supplier;

/**
 * Created by stian on 4/6/18.
 */

//0 in 1 out
//get()
public class SupplierApp {
    public static void main(String[] args) {
        //define a Supplier
        Supplier<Date> today = () -> new Date();
        Date date1 = today.get();

        Person newPerson = initPerson().get();
        System.out.println(newPerson.toString());

        Person newPerson2 = initPerson2();
        System.out.println(newPerson2.toString());


    }


    public static Supplier<Person> initPerson(){
        Supplier<Person> tian = () -> new Person("siyu", "tian", 0, Person.Gender.FEMALE);// way 1

        return tian;
    }

    public static Person initPerson2(){
        Supplier<Person> tian = () -> {
             return new Person("siyu", "tian", 0, Person.Gender.FEMALE); // way 2
        };
        return tian.get();
    }
}
