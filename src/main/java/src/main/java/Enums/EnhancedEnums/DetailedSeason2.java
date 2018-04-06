package src.main.java.Enums.EnhancedEnums;

/**
 * Created by stian on 3/20/18.
 */
public enum DetailedSeason2 {

    WINTER {
        public void print(){
            System.out.println("12 -2");
        }
    },
    SPRING {
        public void print(){
            System.out.println("3-5");
        }
    },
    SUMMER,
    FALL;

    public void print() {
        System.out.println("6-11");
    }
}
