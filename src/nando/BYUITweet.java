package nando;

import java.util.Comparator;

/**
 * Created by fernandogomez on 5/4/17.
 */
public class BYUITweet implements Comparable<BYUITweet> {

    User user;
    String text;

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public void setText(String text) {

        this.text = text;
    }

    @Override
    public int compareTo(BYUITweet o) {
        int compareFollowers = ((BYUITweet) o).getUser().getFollowers();

        return compareFollowers - this.getUser().getFollowers();
    }
}
