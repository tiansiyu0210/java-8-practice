package src.main.java.BuilderPattern;

/**
 * Created by siyu on 5/3/2017.
 */
public class AppBuilderPattern {

    public static void main(String[] args){
        User tian = new User.UserBuilder("siyu", "tian").age(29).phone("123").address("1000 main st").build();
    }

}
