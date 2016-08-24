package com.vishnus1224.teamworkapidemo.datastore;

import com.vishnus1224.rxjavateamworkclient.client.LatestActivityApiClient;
import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;
import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponseWrapper;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

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
    public Observable<List<LatestActivityResponse>> getLatestActivity() {

        return latestActivityApiClient.getLatestActivity().
                flatMap(new Func1<LatestActivityResponseWrapper, Observable<List<LatestActivityResponse>>>() {
                    @Override
                    public Observable<List<LatestActivityResponse>> call(LatestActivityResponseWrapper latestActivityResponseWrapper) {

                        return Observable.just(latestActivityResponseWrapper.getLatestActivityResponseList());

                    }
                });

    }
}
