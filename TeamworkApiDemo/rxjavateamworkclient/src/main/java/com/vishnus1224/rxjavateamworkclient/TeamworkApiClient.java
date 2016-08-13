package com.vishnus1224.rxjavateamworkclient;

/**
 * Created by Vishnu on 8/13/2016.
 */
public class TeamworkApiClient {

    private final String apiToken;

    private final String url;

    public TeamworkApiClient(String apiToken, String url){

        if(apiToken == null || apiToken.isEmpty()){

            throw new IllegalArgumentException("Token cannot be null or empty");

        }

        if(url == null || url.isEmpty()){

            throw new IllegalArgumentException("Url cannot be null or empty");

        }

        this.apiToken = apiToken;
        this.url = url;

    }
}
