package Poker;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by thoma on 16/04/2017.
 */
public class ResponseGenerator implements StatusListener{
    @Override
    public void onStatus(Status status) {

        String screenName = status.getUser().getScreenName();
        ConfigurationBuilder statusConf = new ConfigurationBuilder();
        statusConf.setDebugEnabled(true)
                .setOAuthConsumerKey("gI8hfIPEQwI2eRtYvZ3sfUAfR")
                .setOAuthConsumerSecret("FC1qT2IKBd3jP77WFYk7NKzAeO3ALYLNl0IeGDwkv7DBaeWDGB")
                .setOAuthAccessToken("852804379685953536-SHv5zWH7061BXx8U65mIFblMGQpKb01")
                .setOAuthAccessTokenSecret("DfxKW7iwwCTDz0j7Ld1D3pxjLg7uqwGT5KzDstnv8g0Ou");

        TwitterFactory tf = new TwitterFactory(statusConf.build());



        //access the twitter API using your twitter4j.properties file
        Twitter twitter = tf.getInstance();

        //send a tweet
//        Status makeStatus;

        try {
            twitter.updateStatus(new StatusUpdate("@" + status.getUser().getScreenName() + "  this is to test For reply option ").inReplyToStatusId(status.getId()));
        } catch (TwitterException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

    }

    @Override
    public void onTrackLimitationNotice(int i) {

    }

    @Override
    public void onScrubGeo(long l, long l1) {

    }

    @Override
    public void onStallWarning(StallWarning stallWarning) {

    }

    @Override
    public void onException(Exception e) {

    }
}