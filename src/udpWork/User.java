package udpWork;

import java.io.Serializable;
import java.net.InetAddress;

/**
 * Created by oleg on 07.05.2017.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private InetAddress host;
    private int port;

    public User(InetAddress address, int port) {
        host = address;
        this.port = port;
    }

    public InetAddress getHost() {
        return host;
    }

    public void setHost(InetAddress host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Host address: ")
                .append(getHost())
                .append(" Port: ")
                .append(getPort());
        return sb.toString();
    }
}
