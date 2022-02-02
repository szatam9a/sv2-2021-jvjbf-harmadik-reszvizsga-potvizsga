package contentsite;

import java.util.Objects;

public class User {
    private String userName;
    private String password;
    private boolean premiumMember;
    private boolean logIn;

    public User(String name, String password) {
        this.userName = name;
        this.password = password;

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

    public String getPassword() {
        return String.valueOf(Objects.hash(userName)).concat(String.valueOf(Objects.hash(password)));
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public boolean isLogIn() {
        return logIn;
    }

    public boolean logIn(String username, String password) {
        if (this.userName.equals(username) && this.password.equals(password))
            return true;
        else return false;
    }
}
