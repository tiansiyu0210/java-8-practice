/**
 * Created by stian on 4/7/18.
 */
package src.main.java.FunctionalInterface.Build_In_Functional_Interface;

import java.util.function.BiPredicate;

/**
 * Created by stian on 4/7/18.
 */
public class PredicateAndBiPredicateApp {

    public static void main(String[] args) {
        BiPredicate<Integer, String> condition = (i, s)-> i>20 && s.startsWith("R");
        System.out.println(condition.test(10,"Ram"));
        System.out.println(condition.test(30,"Shyam"));
        System.out.println(condition.test(30,"Ram"));
    }
}
