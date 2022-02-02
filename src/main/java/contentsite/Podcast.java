package contentsite;

import java.util.LinkedList;
import java.util.List;

public class Podcast implements Content {
    private boolean premium = false;
    private String title;
    private List<String> speakers;
    private List<User> clickers = new LinkedList<>();

    public Podcast(String title, List<String> contributors) {
        this.title = title;
        this.speakers = contributors;
    }

    @Override
    public boolean isPremiumContent() {
        return premium;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<User> clickedBy() {
        return new LinkedList<>(clickers);
    }

    @Override
    public void click(User user) {
        clickers.add(user);
    }

    public List<String> getSpeakers() {
        return speakers;
    }
}
