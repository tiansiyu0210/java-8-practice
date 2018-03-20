package src.main.java.Compare.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by siyu on 5/11/2017.
 */
public class AppComparable {

    public static void main(String[] args) {
        List<Duck> duckList = new ArrayList<>();
        duckList.add(new Duck("a"));
        duckList.add(new Duck("A"));
        duckList.add(new Duck("B"));
        duckList.add(new Duck("b"));
        duckList.add(new Duck("2"));
        duckList.add(new Duck("3"));

        Collections.sort(duckList);

        System.out.println(duckList); //[Duck{name='2'}, Duck{name='3'}, Duck{name='A'}, Duck{name='B'}, Duck{name='a'}, Duck{name='b'}]
        System.out.println(new Duck("x").compareTo(new Duck("y"))); // x<y so -1
    }

}
