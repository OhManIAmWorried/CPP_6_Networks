package udpWork;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by oleg on 07.05.2017.
 */
public class ActiveUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<User> users;

    public ActiveUsers() {
        users = new ArrayList<User>();
    }

    public void add(User user) {
        users.add(user);
    }

    public boolean isEmpty() {
        return users.isEmpty();
    }

    public int size() {
        return users.size();
    }

    public boolean contains(User user) {
        return users.contains(user);
    }

    public User get(int index) {
        return users.get(index);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void clear() {
        users.clear();
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (User u : users)
            buf.append(u).append("\n");
        return buf.toString();
    }
}
