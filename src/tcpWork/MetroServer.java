package tcpWork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by oleg on 08.05.2017.
 */
public class MetroServer extends Thread {
    private MetroCardBank metroCardBank = null;
    private ServerSocket serverSocket = null;
    private int serverPort = -1;

    public static void main(String[] args) {
        MetroServer metroServer = new MetroServer(7891);
        metroServer.start();
    }

    public MetroServer(int port) {
        this.metroCardBank = new MetroCardBank();
        this.serverPort = port;
    }

    public void setMetroCardBank(MetroCardBank metroCardBank) {
        this.metroCardBank = metroCardBank;
    }

    public MetroCardBank getMetroCardBank() {
        return metroCardBank;
    }

    //TODO: create method for ending server's lifetime

    @Override
    public void run() {
        try {
            this.serverSocket = new ServerSocket(serverPort);
            System.out.println("Metro Server started");
            while (true) {
                System.out.println("New Client Waiting...");
                Socket socket = serverSocket.accept();
                System.out.println("New client: " + socket);
                ClientHandler clientHandler = new ClientHandler(this.getMetroCardBank(),socket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: " + e);
        } finally {
            try {
                serverSocket.close();
                System.out.println("Metro Server stopped");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error: " + e);
            }
        }
    }
}
