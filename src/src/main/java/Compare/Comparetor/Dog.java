package Compare.Comparetor;

/**
 * Created by siyu on 5/12/2017.
 */
public class Dog {

    public Dog(String name, int weight, String type) {
        this.name = name;
        this.weight = weight;
        this.type = type;
    }

    private String name;
    private int weight;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", type='" + type + '\'' +
                '}';
    }
}
