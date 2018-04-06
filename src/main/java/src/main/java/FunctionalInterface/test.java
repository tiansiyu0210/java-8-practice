package src.main.java.FunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by siyu on 4/30/2017.
 */
public class test implements CreateTradeWithDefaultMethod{
    public static void main(String[] args) {
        System.out.println("===============functional interface test ======================");

        Trade trade1 = new Trade("NEW","tian", 100);
        Trade trade2 = new Trade("NEW","wang", 1000);
        Trade trade3 = new Trade("NEW","lee", 300);
        Trade trade4 = new Trade("CANCELED","tian", 500);
        Trade trade5 = new Trade("CANCELED","wang", 700);
        Trade trade6 = new Trade("CANCELED","chris", 500);
        Trade trade7 = new Trade("CANCELED","chris", 300);
        Trade trade8 = new Trade("CLOSED","chris", 500);
        Trade trade9 = new Trade("CLOSED","tian", 900);
        Trade trade10 = new Trade("CLOSED","doug", 200);
        List<Trade> allTrades = new ArrayList<Trade>();
        allTrades.add(trade1);
        allTrades.add(trade2);
        allTrades.add(trade3);
        allTrades.add(trade4);
        allTrades.add(trade5);
        allTrades.add(trade6);
        allTrades.add(trade7);
        allTrades.add(trade8);
        allTrades.add(trade9);
        allTrades.add(trade10);



        //one condition
        TradeFilter newTradeCheck = t -> t.getStatus().equals("NEW");
        TradeFilter tianTradeCheck = (Trade t) -> t.getIssuer().equalsIgnoreCase("tian");

        //multiple conditions
        TradeFilter tianORChrisLessThan600Trade = t -> {
            return (t.getIssuer().equalsIgnoreCase("tian")
                    || t.getIssuer().equalsIgnoreCase("chris"))
                    && t.getQuantity() <= 600;
        };

        boolean isNewTrade = checkTrade(trade1, newTradeCheck);//
        System.out.println("trade1 " + isNewTrade); //true

        boolean isTianTrade = checkTrade(trade4, tianTradeCheck);
        System.out.println("trade4 " + isTianTrade); //true

        List<Trade> filtedTrade = tradeFilter(allTrades, tianORChrisLessThan600Trade);
        for(Trade trade : filtedTrade) {
            System.out.println(trade.getIssuer() + " " + trade.getStatus() + " " + trade.getQuantity());
        }

        System.out.println("===============Pre-Built functions library ======================");
        /*
            Pre-Built functions library
         */
        System.out.println("===============java.util.Predicate======================");
        //java.util.Predicate,   accept a T and return a boolean
        Predicate<String> isShortString = s -> s.length()<=5;
        System.out.println(isShortString.test("hello")); //true

        Predicate<Trade> isLessThan300 = t -> t.getQuantity() <= 300;
        System.out.println("trade5 is less than 300 " + isLessThan300.test(trade5)); //false 700

        Predicate<String> isBetween5To10 = s -> {
            return s.length() >= 5 && s.length() <= 10;
        };
        System.out.println(isBetween5To10.test("this is a function interface tset class"));//false

        System.out.println("===============java.util.Function======================");
        //java.util.Function, accept a T and retuen a R
        //        @FunctionalInterface
        //        public interface Function<T, R> {
        //            R apply(T t);
        //        }

        Function<Integer, Integer> add5 = x -> x+5;
        System.out.println(add5.apply(5)); //10

        Function<String, Integer> stringToInt = x -> Integer.valueOf(x);
        System.out.println(stringToInt.apply("123"));//123

        // Function to calculate the aggregated quantity of all the trades - taking in a collection and returning an integer!
        Function<List<Trade>,Integer> aggegatedQuantity = t -> {
            int sumQuantity = 0;
            //steam api got used here
            sumQuantity = t.stream().mapToInt(trade -> trade.getQuantity()).sum();
            return sumQuantity;
        };
        System.out.println(aggegatedQuantity.apply(allTrades));// sum all quantity

        System.out.println("===============java.util.BiFunction======================");
        //Two argument functions
        //BiFunction
        //        @FunctionalInterface
        //        public interface BiFunction<T, U, R> {
        //            R apply(T t, U u);
        //        }

        BiFunction<Trade,Trade,Integer> sumQuantities = (t1, t2) -> {
            return t1.getQuantity()+t2.getQuantity();
        };

        System.out.println(sumQuantities.apply(trade7, trade8));// 300 + 500 = 800


        System.out.println("===============CreateTradeWithDefaultMethod======================");
        Trade sysTrade = new test().createSystemTrade();
        System.out.println(sysTrade.getIssuer() + " " + sysTrade.getQuantity() + " " + sysTrade.getStatus());

    }

    private static boolean checkTrade(Trade trade, TradeFilter tradeFilter){
        return tradeFilter.check(trade);
    }

    private static List<Trade> tradeFilter (List<Trade> trades, TradeFilter tradeFilter){
        List<Trade> qaulifiedTrades = new ArrayList<Trade>();
        for(Trade trade : trades){
            if (tradeFilter.check(trade)){
                qaulifiedTrades.add(trade);
            }
        }
        return qaulifiedTrades;
    }

    private Trade createSystemTrade(){
        Trade a = new Trade();
        //CreateTradeWithDefaultMethod
         CreateTradeWithDefaultMethod createTradeWithDefaultMethod = quantity -> {
            Trade systemTrade = new Trade();
            systemTrade.setQuantity(quantity);
            systemTrade.setIssuer(createSystemIssuer());
            systemTrade.setStatus(createNewStatus());
            return systemTrade;
        };

        return createTradeWithDefaultMethod.init(123);

    }

    @Override
    public Trade init(int quantity) {
        return null;
    }
}
