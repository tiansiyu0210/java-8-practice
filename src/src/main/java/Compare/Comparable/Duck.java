package src.main.java.Compare.Comparable;


import com.sun.istack.internal.NotNull;

/**
 * Created by siyu on 5/11/2017.
 */
public class Duck implements Comparable<Duck>{

    public Duck(String name) {
        this.name = name;
    }

    public Duck(){};

    private String name;
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

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(@NotNull Duck o) {
        return name.compareTo(o.name);  //call String's compareTo
    }
    //compareTo() and equals() need consistency, so if comapreTo() returns 0 then equals() should return true;
}
