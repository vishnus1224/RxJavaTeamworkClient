package com.vishnus1224.teamworkapidemo.manager;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Manager for handling operations related to api token.
 * Created by Vishnu on 8/14/2016.
 */
@Singleton
public class TokenManager {

    private String apiToken;

    @Inject
    public TokenManager(){


    }

    public String getApiToken(){

        return apiToken;

    }

    public void setApiToken(String apiToken){

        this.apiToken = apiToken;

    }
}
