package nando;

import com.google.gson.Gson;
import twitter4j.*;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fernandogomez on 5/4/17.
 */
public class TweetLoader {

    private Twitter twitter;
    private int followerCount = 0;



    public TweetLoader() {

        configureKeys();

    }

    public int getFollwerCount() {
        return followerCount;
    }


    private void configureKeys(){

        ConfigurationBuilder cb = new ConfigurationBuilder();

// This continuous set of function calls all connected together is referred to
// as "method chaining". It is a popular technique amongst web developers and has
// gradually found its way into other languages.
//
// The way it works is that each setter returns a reference to the object.
// For example, the code in the setDebugEnabled function might look like this:
//
//  ConfigurationBuilder setDebugEnabled(Boolean value) {
//      this.debugEnabled = value;
//
//      // Returning "this" allows method chaining.
//      return this;
//  }
//
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("Private")
                .setOAuthConsumerSecret("Private")
                .setOAuthAccessToken("Private")
                .setOAuthAccessTokenSecret("Private")
                .setJSONStoreEnabled(true);

        TwitterFactory tf = new TwitterFactory(cb.build());
        this.twitter = tf.getInstance();

    }


    public Map<String, BYUITweet> retrieveTweetsWithHashTag(String hashtag) throws TwitterException {

        String tweetString = "";
        String userName = "";


        Gson gson = new Gson();

        Map<String, BYUITweet> tweetRetrieval = new HashMap<>();

        Query query = new Query(hashtag);

        QueryResult result = twitter.search(query);


        for (Status status : result.getTweets()) {

            tweetString = TwitterObjectFactory.getRawJSON(status);

            BYUITweet newObject = gson.fromJson(tweetString, BYUITweet.class);

            userName = newObject.getUser().getName();

            tweetRetrieval.put(userName, newObject);

        }
        return  tweetRetrieval;
    }

    public void display() {
        System.out.println();
    }
}
