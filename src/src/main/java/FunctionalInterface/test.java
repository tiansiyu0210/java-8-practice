package FunctionalInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siyu on 4/30/2017.
 */
public class test {
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
}
