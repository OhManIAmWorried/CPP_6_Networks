package tcpWork.cardOperations;

/**
 * Created by oleg on 08.05.2017.
 */
public class PayMoneyOperation extends CardOperation {
    private String serNum = null;
    private double money = 0d;

    public PayMoneyOperation() {
        this(null,0d);
    }

    public PayMoneyOperation(String serNum, double money) {
        this.serNum = serNum;
        this.money = money;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum;
    }

    public String getSerNum() {
        return serNum;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }
}
