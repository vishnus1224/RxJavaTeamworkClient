package com.vishnus1224.rxjavateamworkclient.config;

/**
 * Created by Vishnu on 8/13/2016.
 */
public class TeamworkApiConfig {

    private final String apiToken;

    private final String baseUrl;

    public TeamworkApiConfig(String apiToken, String baseUrl) {

        if (apiToken == null || apiToken.isEmpty()) {

            throw new IllegalArgumentException("Token cannot be null or empty");

        }

        if (baseUrl == null || baseUrl.isEmpty()) {

            throw new IllegalArgumentException("Url cannot be null or empty");

        }

        this.apiToken = apiToken;

        this.baseUrl = baseUrl;


    }

    public String getApiToken() {
        return apiToken;
    }

    public String getBaseUrl() {
        return baseUrl;
    }


}
