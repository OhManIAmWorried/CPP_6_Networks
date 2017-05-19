package tcpWork;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by oleg on 08.05.2017.
 */
public class User implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private static final DateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
    private static final DateFormat dateParser = dateFormatter;
    private String name;
    private String surName;
    private String sex;
    private Date birthday;

    public User() {
        this.name = "John";
        this.surName = "Smith";
        this.sex = "male";
        try {
            this.birthday = dateParser.parse("01.01.1970");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Error: " + e);
        }
    }

    public User(String name, String surName, String sex, String birthday) {
        this.name = name;
        this.surName = surName;
        this.sex = sex;
        try {
            this.birthday = dateParser.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Error: " + e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name)
                .append(" ")
                .append(surName)
                .append(" ")
                .append(sex)
                .append(" ")
                .append(dateFormatter.format(birthday));
        return sb.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setBirthday(String birthday) {
        try {
            this.birthday = dateFormatter.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Error: " + e);
        }
    }

    public String getBirthday() {
        return birthday.toString();
    }
}
