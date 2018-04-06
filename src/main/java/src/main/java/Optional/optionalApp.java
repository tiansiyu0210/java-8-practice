/**
 * Created by stian on 4/2/18.
 */
package src.main.java.Optional;

import src.main.java.Enums.BaseEnums.Season;

import java.util.Optional;

/**
 * Created by stian on 4/2/18.
 */
public class optionalApp {

    public static void main(String[] args) {

        /*
            basic Optional
         */
        Optional<String> name = Optional.of("siyu tian");
        System.out.println(name); //Optional[siyu tian]
        System.out.println(name.get());//siyu tian


        String test = "test";
        String testNull = null;
        System.out.println(Optional.ofNullable(test)); //Optional[test]
        System.out.println(Optional.ofNullable(testNull));//Optional.empty

        //System.out.println(Optional.of(testNull)); //java.lang.NullPointerException

        /*
            optional map and flatMap
         */
        //This method “maps” or converts an Optional to another Optional using a Function as parameter.
        // The mapping is only executed, if the result of the past Function is not null.

        Optional<String> animal =  Optional.of("dog");
        Optional<String> emptyAnimal = Optional.empty();

        System.out.println(animal.map(String::toUpperCase));//Optional[DOG]
        System.out.println(animal.map(String::toUpperCase).get()); //DOG
        System.out.println(emptyAnimal.map(String::toUpperCase));//Optional.empty
        //System.out.println(emptyAnimal.map(String::toUpperCase).get()); //java.util.NoSuchElementException: No value present
        Optional<Integer> animalLength = animal.map(String::length);
        Optional<Integer> animalLength2 = animal.map(x -> x.length());

        System.out.println(animalLength); //Optional[3]
        System.out.println(animalLength2);//Optional[3]

        Optional<Optional<String>> nonEmptyOptionalGender = Optional.of(Optional.of("male"));
        System.out.println("Optional value   :: " + nonEmptyOptionalGender);
        System.out.println("Optional.map     :: " + nonEmptyOptionalGender.map(gender -> gender.map(String::toUpperCase)));
        System.out.println("Optional.flatMap :: " + nonEmptyOptionalGender.flatMap(gender -> gender.map(String::toUpperCase)));

        /*
            optional filter
         */
        //a filter() method that expects a Predicate and returns an Optional back if the Predicate is true
        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();

        //Filter on Optional
        System.out.println(gender.filter(g -> g.equals("male"))); //Optional.empty
        System.out.println(gender.filter(g -> g.equalsIgnoreCase("MALE"))); //Optional[MALE]
        System.out.println(emptyGender.filter(g -> g.equalsIgnoreCase("MALE"))); //Optional.empty

        /*
            optional isPresent and ifPresent
         */
        if (gender.isPresent()) {
            System.out.println("Value available.");
        } else {
            System.out.println("Value not available.");
        }  //Value available.

        gender.ifPresent(g -> System.out.println("In gender Option, value available."));

        //condition failed, no output print
        emptyGender.ifPresent(g -> System.out.println("In emptyGender Option, value available."));


        /*
            Optional orElse methods
         */

        System.out.println(gender.orElse("<N/A>")); //MALE
        System.out.println(emptyGender.orElse("<N/A>")); //<N/A>

        System.out.println(gender.orElseGet(() -> "<N/A>")); //MALE
        System.out.println(emptyGender.orElseGet(() -> "<N/A>")); //<N/A>
    }

}
