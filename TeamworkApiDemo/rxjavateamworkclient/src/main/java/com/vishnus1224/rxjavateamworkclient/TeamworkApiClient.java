package com.vishnus1224.rxjavateamworkclient;

/**
 * Created by Vishnu on 8/13/2016.
 */
public class TeamworkApiClient {

    private final String apiToken;

    public TeamworkApiClient(String apiToken){

        if(apiToken == null || apiToken.isEmpty()){

            throw new IllegalArgumentException("Token cannot be null or empty");

        }

        this.apiToken = apiToken;

    }
}
