package tcpWork;

/**
 * Created by oleg on 08.05.2017.
 */
public class MetroCard implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String serNum;
    private User user;
    private String college;
    private double balance;

    public MetroCard() {
        serNum = "0";
        user = new User();
        college = "Lorem ipsum";
        balance = 0d;
    }

    public MetroCard(String serNum, User usr, String college, double balance) {
        this.serNum = serNum;
        this.user = usr;
        this.college = college;
        this.balance = balance;
    }
    
    public String getSerNum() {
        return serNum;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String colledge) {
        this.college = colledge;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("№: ")
                .append(serNum)
                .append("\nUser: ")
                .append(user)
                .append("\nCollege: ")
                .append(college)
                .append("\nBalance: ")
                .append(balance);
        return sb.toString();
    }
}
