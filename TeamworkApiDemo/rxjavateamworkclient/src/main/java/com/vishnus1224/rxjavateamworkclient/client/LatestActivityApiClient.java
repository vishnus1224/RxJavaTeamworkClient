package com.vishnus1224.rxjavateamworkclient.client;

import com.vishnus1224.rxjavateamworkclient.api.LatestActivityApi;
import com.vishnus1224.rxjavateamworkclient.config.TeamworkApiConfig;
import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponseWrapper;

import java.util.List;

import rx.Observable;

/**
 * Created by Vishnu on 8/22/2016.
 */
public class LatestActivityApiClient extends TeamworkApiClient implements Limitable, Starred {

    private static final int DEFAULT_MAX_ITEMS = 60;

    private static final int MAX_ITEM_LIMIT = 200;

    private int maxItems = DEFAULT_MAX_ITEMS;

    private boolean onlyStarred = false;

    public LatestActivityApiClient(TeamworkApiConfig teamworkApiConfig) {
        super(teamworkApiConfig);
    }

    public Observable<LatestActivityResponseWrapper> getLatestActivity(){

        return getRetrofit().create(LatestActivityApi.class).getLatestActivity(maxItems, onlyStarred);

    }

    @Override
    public LatestActivityApiClient maxItems(int count) {

        if(count < 0){

            throw new IllegalArgumentException("MaxItems should be greater than 0");

        }

        maxItems = count > MAX_ITEM_LIMIT ? MAX_ITEM_LIMIT : count;

        return this;

    }

    @Override
    public LatestActivityApiClient onlyStarred(boolean value) {

        onlyStarred = value;

        return this;

    }
}
