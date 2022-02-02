package contentsite;

import java.util.LinkedList;
import java.util.List;

public class Video implements Content {
    private String title;
    private int length;
    private boolean premium;
    private List<User> clickers = new LinkedList<>();

    public Video(String title, int length) {
        this.title = title;
        this.length = length;
        if (length > 15) premium = true;
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
}
