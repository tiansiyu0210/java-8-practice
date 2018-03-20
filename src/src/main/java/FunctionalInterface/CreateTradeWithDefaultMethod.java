package src.main.java.FunctionalInterface;

/**
 * Created by siyu on 4/30/2017.
 */
@FunctionalInterface
public interface CreateTradeWithDefaultMethod {

    Trade init(int quantity);

    // default method - note the keyword default
    default String createSystemIssuer(){
        return "system issuer";
    }
    // default method - note the keyword default
    default String createNewStatus(){
        return "NEW";
    }
}
