package tcpWork.cardOperations;

import tcpWork.MetroCard;

/**
 * Created by oleg on 08.05.2017.
 */
public class AddMetroCardOperation extends CardOperation {
    private MetroCard metroCard = null;

    public AddMetroCardOperation() {
        metroCard = new MetroCard();
    }

    public MetroCard getMetroCard() {
        return metroCard;
    }
}
