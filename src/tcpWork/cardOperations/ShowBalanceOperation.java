package tcpWork.cardOperations;

/**
 * Created by oleg on 08.05.2017.
 */
public class ShowBalanceOperation extends CardOperation {
    private String serNum = null;

    public ShowBalanceOperation() {
    }

    public ShowBalanceOperation(String serNum) {
        this.serNum = serNum;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum;;
    }

    public String getSerNum() {
        return serNum;
    }
}
