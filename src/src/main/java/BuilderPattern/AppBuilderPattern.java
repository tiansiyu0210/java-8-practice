package src.main.java.BuilderPattern;

import java.util.Arrays;

/**
 * Created by siyu on 5/3/2017.
 */
public class AppBuilderPattern {

    public static void main(String[] args){
        User tian = new User.UserBuilder("siyu", "tian").age(29).phone("123").address("1000 main st").build();

//        String[] tests = {"STRING", "REGEX", "UNUSED_IP_ADDR","UNUSED_CIDR","MD5","SHA1","SHA256","SHA512","IPV4","IPV6","IPV4_CIDR","IPV6_CIDR"};
//        String[] tests2 = new String[12];
//
//
//        for (int i = 0; i < tests.length; i++){
//            int j = i + 1;
//            String a = tests[i] +  "   +" + j;
//            tests2[i] = a;
//        }
//
//        Arrays.sort(tests);
//        for (int i = 0; i < tests.length; i++){
//            System.out.print(tests[i] + "   ");
//        }
//
//        System.out.println(" ");
//        Arrays.sort(tests2);
//
//        for (int i = 0; i < tests2.length; i++){
//            System.out.print(tests2[i] + " ");
//        }



    }

}
