package src.main.java.Enums;

import src.main.java.Enums.BaseEnums.Season;
import src.main.java.Enums.EnhancedEnums.DetailedSeason;
import src.main.java.Enums.EnhancedEnums.DetailedSeason2;
import src.main.java.Enums.EnhancedEnums.DetailedSeason3;

/**
 * Created by stian on 3/19/18.
 */
public class AppEnums {


    public static void main(String[] args) {
        /*
            Season tests
        */
        Season s = Season.SUMMER;
        System.out.println(s == Season.SUMMER); //true

//        WINTER 0
//        SPRING 1
//        SUMMER 2
//        FALL 3
        for(Season season : Season.values()){
            System.out.println(season.name() + " " + season.ordinal());
        }

        //if(Season.SPRING == 2) ------> wrong

        Season summer = Season.valueOf("SUMMER");
        System.out.println(summer == s);   //true


        //cannot extend an Enum class

        //switch
        switch (summer){
            case SPRING:
                System.out.println("spring");
                break;
            case SUMMER:
                System.out.println("summer");
                break;
            default:
                System.out.println("other");
        }



         /*
            Detailed Season tests
        */
        DetailedSeason detailedSeason = DetailedSeason.FALL;
        detailedSeason.print(); //  qiu


        DetailedSeason2.FALL.print(); //6-11
        DetailedSeason2.WINTER.print(); // 12-2

        DetailedSeason3.SPRING.print();//3-5


    }

}
