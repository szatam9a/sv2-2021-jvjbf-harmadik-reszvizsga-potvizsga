package contentsite;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ContentService {
    private Set<User> allUsers = new HashSet<>();
    private Set<Content> allContent = new HashSet<>();

    void registerUser(String name, String password) {

        if (allUsers.stream().anyMatch(e -> e.getUserName().equals(name))) {
            throw new IllegalArgumentException("Username is already taken: " + name);
        } else
            allUsers.add(new User(name, password));
    }

    void addContent(Content content) {
        if (allContent.stream().anyMatch(e -> e.getTitle().equals(content.getTitle()))) {
            throw new IllegalArgumentException("Content name is already taken: " + content.getTitle());
        } else
            allContent.add(content);
    }

    void logIn(String username, String password) {
        if (!allUsers.stream().anyMatch(e -> e.getUserName().equals(username))) {
            throw new IllegalArgumentException("Username is wrong!");
        }
        User userTologin = allUsers.stream().filter(e -> e.getUserName().equals(username)).findFirst().get();
        if (userTologin.logIn(username, password)) {
            userTologin.setLogIn(true);
        } else throw new IllegalArgumentException("Password is Invalid!");
    }

    void clickOnContent(User user, Content content) {
        if (!user.isLogIn()) {
            throw new IllegalStateException("Log in to watch this content!");
        }
        if (content.isPremiumContent()) {
            if (user.isPremiumMember()) {
                content.click(user);
            } else throw new IllegalStateException("Upgrade for Premium to watch this content!");
        }
        content.click(user);
    }

    public Set<User> getAllUsers() {
        return allUsers;
    }

    public Set<Content> getAllContent() {
        return allContent;
    }
}
