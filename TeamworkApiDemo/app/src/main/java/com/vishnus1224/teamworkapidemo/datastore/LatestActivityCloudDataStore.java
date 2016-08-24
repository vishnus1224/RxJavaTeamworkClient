package com.vishnus1224.teamworkapidemo.datastore;

import com.vishnus1224.rxjavateamworkclient.client.LatestActivityApiClient;
import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by vishnu on 24/08/16.
 */
public class LatestActivityCloudDataStore implements LatestActivityDataStore {

    private LatestActivityApiClient latestActivityApiClient;

    @Inject
    public LatestActivityCloudDataStore(LatestActivityApiClient latestActivityApiClient) {

        this.latestActivityApiClient = latestActivityApiClient;

    }

    @Override
    public List<LatestActivityResponse> getLatestActivity() {
        return null;
    }
}
