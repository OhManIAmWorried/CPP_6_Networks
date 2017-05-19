package tcpWork.cardOperations;

/**
 * Created by oleg on 08.05.2017.
 */
public class RemoveCardOperation extends CardOperation {
    private String serNum = null;

    public RemoveCardOperation(String serNum) {
        this.serNum = serNum;
    }

    public RemoveCardOperation() {
    }

    public String getSerNum() {
        return serNum;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum;
    }
}
