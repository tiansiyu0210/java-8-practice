package src.main.java.BuilderPattern;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by siyu on 5/3/2017.
 */
public class AppBuilderPattern {

    //public static final SimpleDateFormat OUTBOUND_DATE_TIME_FORMATTER = SimpleDateFormat.("yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'").withZone(ZoneId.of(ZoneOffset.UTC.getId()));

    public static void main(String[] args) throws ParseException {
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


        String date  = "2016-01-01";
//        Instant renderAt = Instant.from(OUTBOUND_DATE_TIME_FORMATTER.parse(date));
//        System.out.println(renderAt.toString());

        String expectedPattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        //formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date1 = formatter.parse(date);
        Date curDate = new Date();


        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        cal.add(Calendar.DATE, -1);
        System.out.println(formatter.format(date1));
        System.out.println(formatter.format(cal.getTime()));
        System.out.println(formatter.format(curDate));

    }

}
