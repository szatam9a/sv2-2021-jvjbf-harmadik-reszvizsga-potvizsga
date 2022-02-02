package contentsite;

import java.io.ObjectStreamException;
import java.util.Objects;

public class User {
    private String userName;
    private int password;
    private boolean premiumMember;
    private boolean logIn;

    public User(String name, String password) {
        this.userName = name;
        this.password = Objects.hash(name+password);

    }

    public boolean upgradeForPremium() {
        return premiumMember = true;
    }

    public void setLogIn(boolean value) {
        logIn = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }

    public String getUserName() {
        return userName;
    }

    public int getPassword() {
        return password;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public boolean isLogIn() {
        return logIn;
    }

    public boolean logIn(String username, String password) {
        if (this.userName.equals(username) && this.password == (Objects.hashCode(username+password)))
            return true;
        else return false;
    }
}
