package Poker;

/**
 * Created by thoma on 31/03/2017.
 */

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class RunTwitterBot {

    //if something goes wrong, we might see a TwitterException
    public static void main(String... args) throws TwitterException{

        System.out.println("yolo");




        ConfigurationBuilder streamConf = new ConfigurationBuilder();
        streamConf.setDebugEnabled(true)
                .setOAuthConsumerKey("gI8hfIPEQwI2eRtYvZ3sfUAfR")
                .setOAuthConsumerSecret("FC1qT2IKBd3jP77WFYk7NKzAeO3ALYLNl0IeGDwkv7DBaeWDGB")
                .setOAuthAccessToken("852804379685953536-SHv5zWH7061BXx8U65mIFblMGQpKb01")
                .setOAuthAccessTokenSecret("DfxKW7iwwCTDz0j7Ld1D3pxjLg7uqwGT5KzDstnv8g0Ou");


        TwitterStream twitterStream = new TwitterStreamFactory(streamConf.build()).getInstance();

        StatusListener listener = new ResponseGenerator();

        FilterQuery fq = new FilterQuery();
        String keywords[] = {"#dealmeinHC"};
        fq.track(keywords);

        twitterStream.addListener(listener);
        twitterStream.filter(fq);



        //print a message so we know when it finishes
        System.out.println("Done.");
    }
}