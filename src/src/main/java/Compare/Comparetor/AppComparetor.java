package Compare.Comparetor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by siyu on 5/12/2017.
 */
public class AppComparetor {

    public static void main(String[] args) {
        Comparator<Dog> byWeight = new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getWeight() - o2.getWeight();
            }
        };

        //
        Comparator<Dog> byWeight1 = (d1, d2) -> d1.getWeight() - d2.getWeight();
        Comparator<Dog> byWeight2 = (Dog d1, Dog d2) -> {return  d1.getWeight() - d2.getWeight();};

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("momo", 5,"A"));
        dogs.add(new Dog("yoyo", 3, "B"));
        dogs.add(new Dog("dodo", 7, "C"));

        Collections.sort(dogs, byWeight);

        System.out.println(dogs);// [Dog{name='yoyo'}, Dog{name='momo'}, Dog{name='dodo'}]



    }

}
