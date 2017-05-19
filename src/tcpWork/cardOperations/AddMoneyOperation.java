package tcpWork.cardOperations;

/**
 * Created by oleg on 08.05.2017.
 */
public class AddMoneyOperation extends CardOperation {
    private String serNum = null;
    private double money = 0d;

    public AddMoneyOperation() {
        this("null",0d);
    }

    public AddMoneyOperation(String serNum, double money) {
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
