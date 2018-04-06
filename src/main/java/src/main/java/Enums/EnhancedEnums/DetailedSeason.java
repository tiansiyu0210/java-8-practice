package src.main.java.Enums.EnhancedEnums;

/**
 * Created by stian on 3/20/18.
 */
public enum DetailedSeason {

    WINTER("dong"),
    SPRING("chun"),
    SUMMER("xia"),
    FALL("qiu");

    private String chinese;

    DetailedSeason(String chinese) {
        this.chinese = chinese;
    }

    //method
    public void print() {
        System.out.println(chinese);
    }
}
