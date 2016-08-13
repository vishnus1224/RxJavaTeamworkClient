package com.vishnus1224.rxjavateamworkclient.client;

import com.vishnus1224.rxjavateamworkclient.api.AuthenticationApi;
import com.vishnus1224.rxjavateamworkclient.config.TeamworkApiConfig;
import com.vishnus1224.rxjavateamworkclient.model.AccountResponse;

import rx.Observable;

/**
 * Client for making authentication requests.
 * Created by Vishnu on 8/13/2016.
 */
public class AuthenticationApiClient extends TeamworkApiClient {

    public AuthenticationApiClient(TeamworkApiConfig teamworkApiConfig) {
        super(teamworkApiConfig);
    }

    /**
     * Authenticate the user.
     * @return Observable containing account details.
     */
    public Observable<AccountResponse> authenticate(){

        return getRetrofit().create(AuthenticationApi.class).authenticate();

    }
}
