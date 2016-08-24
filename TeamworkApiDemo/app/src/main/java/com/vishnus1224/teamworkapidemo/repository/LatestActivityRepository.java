package com.vishnus1224.teamworkapidemo.repository;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;
import com.vishnus1224.teamworkapidemo.datastore.LatestActivityDataStore;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;

/**
 * Created by vishnu on 24/08/16.
 */
public class LatestActivityRepository implements BaseRepository<LatestActivityResponse> {

    private LatestActivityDataStore latestActivityDataStore;

    @Inject
    public LatestActivityRepository(@Named("activityCloudDataStore") LatestActivityDataStore latestActivityDataStore) {

        this.latestActivityDataStore = latestActivityDataStore;

    }

    @Override
    public void add(LatestActivityResponse latestActivityResponse) {

    }

    @Override
    public LatestActivityResponse removeItem() {
        return null;
    }

    @Override
    public Observable<LatestActivityResponse> getItem() {
        return null;
    }

    @Override
    public Observable<List<LatestActivityResponse>> getAllItems() {

        return latestActivityDataStore.getLatestActivity();

    }

}
