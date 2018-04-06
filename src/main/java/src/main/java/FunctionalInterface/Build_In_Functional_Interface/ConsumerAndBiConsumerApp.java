/**
 * Created by stian on 4/6/18.
 */
package src.main.java.FunctionalInterface.Build_In_Functional_Interface;

import src.main.java.Beans.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by stian on 4/6/18.
 */
//consumer 1 in 0 out
//BiConsumer 2 in 0 out
//accept(T)   accept(K, V)
public class ConsumerAndBiConsumerApp {
    public static void main(String[] args) {

        Person p1 = new Person("siyu", "tian", 5, Person.Gender.MALE);
        Person p2 = new Person("shan", "cao", 4, Person.Gender.FEMALE);

        List<Person> personList = new ArrayList<>();

        addPersonIntoList(p1, personList);
        addPersonIntoList(p2, personList);

        personList.forEach(person -> System.out.println(person.toString()));

        marry(p1, p2);
        System.out.println(p1);
        System.out.println(p2);
    }
    //age plus 100 and put into list
    public static void addPersonIntoList(Person person, List<Person> persons){
        Consumer<Person> test = p -> {
            p.setAge(p.getAge() + 100);
            persons.add(p);
        };
        test.accept(person);
    }

    //set spouse to each other
    public static void marry(Person p1, Person p2){
        BiConsumer<Person, Person> happyMarry = (person1, person2) -> {
            person1.setMarry(true);
            person2.setMarry(true);
        };

        happyMarry.accept(p1, p2);
    }
}
