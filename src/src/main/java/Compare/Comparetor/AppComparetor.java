package src.main.java.Compare.Comparetor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.reverseOrder;

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

        //lambda way
        Comparator<Dog> byWeight1 = (d1, d2) -> d1.getWeight() - d2.getWeight();
        Comparator<Dog> byWeight2 = (Dog d1, Dog d2) -> {return  d1.getWeight() - d2.getWeight();};

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("momo", 5,"A"));
        dogs.add(new Dog("yoyo", 3, "B"));
        dogs.add(new Dog("dodo", 10, "B"));
        dogs.add(new Dog("dodo", 3, "C"));
        dogs.add(new Dog("dodo", 7, "C"));
        dogs.add(new Dog("huhu", 7, "C"));
        dogs.add(new Dog("kaka", 7, "A"));
        dogs.add(new Dog("kaka", 6, "C"));
        dogs.add(new Dog("yoyo", 2, "B"));

        //single field
        //Collections.sort(dogs, byWeight);
        //System.out.println(dogs);// [Dog{name='yoyo'}, Dog{name='momo'}, Dog{name='dodo'}]

        //multiple compare
        Comparator<Dog> nameThenWeight = new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                int result = o1.getName().compareTo(o2.getName());//can be replaced as lambda
                if(result != 0){
                    return result;
                }else {
                    return o1.getWeight() - o2.getWeight();
                }
            }
        };

        Collections.sort(dogs, nameThenWeight);
        dogs.stream().forEach(d -> System.out.println(d));

        System.out.println("=====================reverse order 1=========================");
        //reverse order
        Collections.sort(dogs, nameThenWeight.reversed());
        dogs.stream().forEach(d -> System.out.println(d));
        System.out.println("=====================reverse order 2=========================");
        dogs.stream().sorted(nameThenWeight.reversed()).collect(Collectors.toList()).forEach(d -> System.out.println(d));

        System.out.println("=====================method reference=========================");
        Comparator<Dog> compareByWeigh3 = DogService::compareByWeight;
        Collections.sort(dogs, compareByWeigh3);
        dogs.stream().forEach(d -> System.out.println(d));

        System.out.println("=====================some list methods=========================");
        System.out.println("=============update all elements================");
        List<Dog> dogs2 = new ArrayList<>();
        dogs2.add(new Dog("haha", 5,"A"));
        dogs2.add(new Dog("lolo", 3, "B"));
        dogs2.add(new Dog("coco", 2, "B"));

        //update all elements
        dogs2.replaceAll(d -> {
            d.setWeight(d.getWeight() * 2);
                    return d;
        });

        dogs2.stream().forEach(d -> System.out.println(d));
        System.out.println("=============remove if================");
        //remove if
        dogs2.removeIf(d-> d.getName().startsWith("c"));
        dogs2.stream().forEach(d -> System.out.println(d));
    }

}
