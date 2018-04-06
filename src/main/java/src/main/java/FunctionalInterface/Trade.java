package src.main.java.FunctionalInterface;

/**
 * Created by siyu on 4/30/2017.
 */
public class Trade {

    private String status;
    private String issuer;
    private int quantity;

    public Trade() {}

    public Trade(String status, String issuer, int quantity) {
        this.status = status;
        this.issuer = issuer;
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
