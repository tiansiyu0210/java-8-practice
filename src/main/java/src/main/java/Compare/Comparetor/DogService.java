package src.main.java.Compare.Comparetor;

/**
 * Created by siyu on 5/15/2017.
 */
public class DogService {
    public static int compareByWeight(Dog d1, Dog d2) {
        return d1.getWeight() - d2.getWeight();
    }

    public static int compareByName(Dog d1, Dog d2) {
        return d1.getName().compareTo(d2.getName());
    }
}
