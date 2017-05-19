package tcpWork;

import java.util.ArrayList;

/**
 * Created by oleg on 08.05.2017.
 */
public class MetroCardBank {
    private ArrayList<MetroCard> store = null;

    public MetroCardBank() {
        store = new ArrayList<MetroCard>();
    }

    public void setStore(ArrayList<MetroCard> store) {
        this.store = store;
    }

    public ArrayList<MetroCard> getStore() {
        return store;
    }

    public int findMetroCard(String serNum) {
        int index = 0;
        for (MetroCard metroCard : store) {
            if (metroCard.getSerNum() == serNum) {
                return index;
            } else { ++index;}
        }
        return -1;
    }

    public int numCards() {
        return store.size();
    }

    public void addCard(MetroCard newCard) {
        System.out.println("Added");
        store.add(newCard);
    }

    public boolean removeCard(String serNum) {
        int index = findMetroCard(serNum);
        if (index != -1) {
            store.remove(index);
            return true;
        } else return false;
    }

    public boolean addMoney(String serNum, double money) {
        int index = findMetroCard(serNum);
        if (index != -1) {
            store.get(index).setBalance(store.get(index).getBalance() + money);
            return true;
        } else return false;
    }

    public boolean getMoney(String serNum, double money) {
        int index = findMetroCard(serNum);
        if (index != -1) {
            if (store.get(index).getBalance() >= money) {
                store.get(index).setBalance(store.get(index).getBalance() - money);
                return true;
            } else return false;
        } else return false;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder("List of MetroCards:");
        for (MetroCard c : store) {
            buf.append("\n\n")
                    .append(c);
        }
        return buf.toString();
    }
}
