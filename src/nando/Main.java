package nando;

import twitter4j.TwitterException;
import java.util.Comparator;

import java.util.*;

public class Main {

    public static void main(String[] args) throws TwitterException {

        TweetLoader loader = new TweetLoader();

        Map<String, BYUITweet> tweets;

        tweets = loader.retrieveTweetsWithHashTag("#byui");

        // putting the map in a Tree automatically sorts the keys!!
        Map<String, BYUITweet> map = new TreeMap<>(tweets);


        System.out.println("****** Sorted by User Name ******" + '\n' + '\n');

        for (Map.Entry<String, BYUITweet> entry : map.entrySet()) {

//            System.out.println(sortedKeys);
            System.out.println(entry.getKey() + " (" + entry.getValue().getUser().getFollowers() + " Followers) - " + entry.getValue().getText() + '\n');
        }


        System.out.println("****** Sorted by Number of Followers ******" + '\n' + '\n');

        List<Map.Entry<String, BYUITweet>> entryList = new ArrayList<Map.Entry<String, BYUITweet>>(map.entrySet());

        Collections.sort(
                entryList, new Comparator<Map.Entry<String, BYUITweet>>() {
                    @Override
                    public int compare(Map.Entry<String, BYUITweet> stringBYUITweetEntry,
                                       Map.Entry<String, BYUITweet> stringBYUITweetEntry2) {
                        return stringBYUITweetEntry.getValue().compareTo(stringBYUITweetEntry2.getValue());
                    }
                });

        for (int i = 0; i < entryList.size(); i++) {
            System.out.println(entryList.get(i).getKey() + " (" + entryList.get(i).getValue().getUser().getFollowers() +
                    " Followers) - " + entryList.get(i).getValue().getText() + '\n');
        }
    }
}




