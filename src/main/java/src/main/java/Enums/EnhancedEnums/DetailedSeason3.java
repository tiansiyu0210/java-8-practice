package src.main.java.Enums.EnhancedEnums;

/**
 * Created by stian on 3/20/18.
 */
public enum DetailedSeason3 {

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
    SUMMER {
        public void print() {
            System.out.println("6-8");
        }
    },
    FALL {
        public void print() {
            System.out.println("9-11");
        }
    };

    public abstract void print();
}
