package com.codepath.apps.mysimpletweets.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Forteson on 02/08/2017.
 */

/*


     */

// Parse the JSON + Store the data, encapsulate state logic or display logic
public class Tweet {
    // list out the attributes
    private String body;
    private long uid; // unique id for the tweet

    public User getUser() {
        return user;
    }

    private User user; // store embedded user object
    private String createAt;

    public String getBody() {
        return body;
    }

    public long getUid() {
        return uid;
    }

    public String getCreateAt() {
        return createAt;
    }

    // Deserialize the JSON and build Tweet objects
    // Tweet.fromJSON(""(...)"")=> <Tweet>
    public static Tweet fromJSON(JSONObject jsonObject) {
        Tweet tweet = new Tweet();
        //Extract the value from the json, store them
        try {
            tweet.body = jsonObject.getString("text");
            tweet.uid = jsonObject.getInt("id");
            tweet.createAt= jsonObject.getString("created at");
             tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // REturn the tweet object
        return tweet;
      }

      // Tweet.fromJSONArray(({...}, {...}
      public static ArrayList<Tweet> fromJSONArray(JSONArray jsonArray){
          ArrayList<Tweet> tweets = new ArrayList<>();
          // Iterate the json array and create tweets
          for (int i = 0; i < jsonArray.length(); i++){
              try {
                  JSONObject tweetJson = jsonArray.getJSONObject(i);
                  Tweet tweet = Tweet.fromJSON(tweetJson);
                  if (tweet != null){
                      tweets.add(tweet);
                  }
              } catch (JSONException e) {
                  e.printStackTrace();
                  continue;
              }
          }
          // Return the finished list
          return tweets;
      }
}

