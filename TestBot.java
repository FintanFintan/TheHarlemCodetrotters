package Poker;

/**
 * Created by thoma on 31/03/2017.
 */

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TestBot{

    //if something goes wrong, we might see a TwitterException
    public static void main(String... args) throws TwitterException{

        System.out.println("yolo");

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("Q3K0UW8dmH4YZPOWZ5Vi5y6Fb")
                .setOAuthConsumerSecret("MxSTwa5xHOTJY4OTuABDi2wAjJIZpvSaXheG7PSNoymgO0z8t9")
                .setOAuthAccessToken("847806423165743106-IDfi9BWuRz15oQSxl26bWJG0ALRzK3I")
                .setOAuthAccessTokenSecret("xEkXCmpQTqsjUpJQbl65wOvKf9TkwtgLYqJZM5YRTeAB7");
        TwitterFactory tf = new TwitterFactory(cb.build());

        //access the twitter API using your twitter4j.properties file
        Twitter twitter = tf.getInstance();

        //send a tweet
        Status status = twitter.updateStatus("                        ? ");

        //print a message so we know when it finishes
        System.out.println("Done.");
    }
}