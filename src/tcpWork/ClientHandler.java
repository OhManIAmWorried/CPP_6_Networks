package tcpWork;

import tcpWork.cardOperations.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by oleg on 08.05.2017.
 */
public class ClientHandler extends Thread {
    private ObjectInputStream ois = null;
    private ObjectOutputStream oos = null;
    private boolean work = true;
    private MetroCardBank metroCardBank = null;
    private Socket socket = null;

    public ClientHandler(MetroCardBank metroCardBank, Socket socket) {
        this.metroCardBank = metroCardBank;
        this.socket = socket;
        this.work = true;
        try {
            this.ois = new ObjectInputStream(socket.getInputStream());
            this.oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: " + e);
        }
    }

    private void finish() throws IOException {
        //work = false;
        oos.writeObject("Finish Work " + socket);
        oos.flush();
    }

    private void addCard(Object object) throws IOException, ClassNotFoundException {
        metroCardBank.addCard(((AddMetroCardOperation)object).getMetroCard());
        oos.writeObject("Card Added");
        oos.flush();
    }

    private void addMoney(Object object) throws IOException, ClassNotFoundException {
        AddMoneyOperation addMoneyOperation =  (AddMoneyOperation) object;
        boolean res = metroCardBank.addMoney(addMoneyOperation.getSerNum(),addMoneyOperation.getMoney());
        if (res) {
            oos.writeObject("Balance Added");
            oos.flush();
        } else {
            oos.writeObject("Cannot Balance Added"); //sic.
            oos.flush();
        }
    }

    private void payMoney(Object object) throws IOException, ClassNotFoundException {
        PayMoneyOperation payMoneyOperation = (PayMoneyOperation) object;
        boolean res = metroCardBank.getMoney(payMoneyOperation.getSerNum(), payMoneyOperation.getMoney());
        if (res) {
            oos.writeObject("Money Payed");
            oos.flush();
        } else {
            oos.writeObject("Cannot Pay Money");
            oos.flush();
        }
    }

    private void removeCard(Object object) throws IOException, ClassNotFoundException {
        RemoveCardOperation removeCardOperation = (RemoveCardOperation) object;
        boolean res = metroCardBank.removeCard(removeCardOperation.getSerNum());
        if (res) {
            oos.writeObject("Metro Card Successfully Remove: " + removeCardOperation.getSerNum());
            oos.flush();
        } else {
            oos.writeObject("Cannot Remove Card" + removeCardOperation.getSerNum());
            oos.flush();
        }
    }

    private void showBalance(Object object) throws IOException, ClassNotFoundException {
        ShowBalanceOperation showBalanceOperation = (ShowBalanceOperation) object;
        int index = metroCardBank.findMetroCard(showBalanceOperation.getSerNum());
        if (index >= 0) {
            oos.writeObject("Card : " + showBalanceOperation.getSerNum() + " balance: "
            + metroCardBank.getStore().get(index).getBalance());
            oos.flush();
        } else {
            oos.writeObject("Cannot Show Balance for Card: " + showBalanceOperation.getSerNum());
        }
    }

    private void error() throws IOException {
        oos.writeObject("Bad Operation");
        oos.flush();
    }

    //TODO: implement the operation of showing the complete information about the Card to the Client

    private void processOperation(Object object) throws IOException, ClassNotFoundException {
        if (object instanceof StopOperation) {
            finish();
        } else if (object instanceof AddMetroCardOperation) {
            addCard(object);
        } else if (object instanceof AddMoneyOperation) {
            addMoney(object);
        } else if (object instanceof PayMoneyOperation) {
            payMoney(object);
        } else if (object instanceof RemoveCardOperation) {
            removeCard(object);
        } else if (object instanceof ShowBalanceOperation) {
            showBalance(object);
        } else {
            error();
        }
    }

    @Override
    public void run() {
        synchronized (metroCardBank) {
            System.out.println("Client Handler Started for: " + socket);
            while (work) {
                Object object;
                try {
                    object = ois.readObject();
                    processOperation(object);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error: " + e);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("Error: " + e);
                }
            }
            try {
                System.out.println("Client Handler Stopped for: " + socket);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error: " + e);
            }
        }
    }
}
