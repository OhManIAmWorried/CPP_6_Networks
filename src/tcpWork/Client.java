package tcpWork;

import tcpWork.cardOperations.*;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by oleg on 08.05.2017.
 */
public class Client {
    private int port = -1;
    private String server = null;
    private Socket socket = null;
    private ObjectInputStream ois = null;
    private ObjectOutputStream oos = null;

    public Client(String server, int port) {
        this.port = port;
        this.server = server;
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(server, port), 1000);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (InterruptedIOException e) {
            e.printStackTrace();
            System.out.println("Error: " + e);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void finish() {
        try {
            oos.writeObject(new StopOperation());
            oos.flush();
            System.out.println(ois.readObject());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error: " + e);
        }
    }

    public void applyOperation(CardOperation cardOperation) {
        try {
            oos.writeObject(cardOperation);
            oos.flush();
            System.out.println(ois.readObject());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: " + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error: " + e);
        }
    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 7891);
        AddMetroCardOperation addMetroCardOperation = new AddMetroCardOperation();
        addMetroCardOperation.getMetroCard().setUser(new User("Petr", "Petrov", "M", "25.12.1968"));
        addMetroCardOperation.getMetroCard().setSerNum("00001");
        addMetroCardOperation.getMetroCard().setCollege("KhNU");
        addMetroCardOperation.getMetroCard().setBalance(25);
        client.applyOperation(addMetroCardOperation);
        client.finish();

        client = new Client("localhost", 7891);
        client.applyOperation(new AddMoneyOperation("00001", 100));
        client.applyOperation(new ShowBalanceOperation("00001"));
        client.finish();
    }
}
