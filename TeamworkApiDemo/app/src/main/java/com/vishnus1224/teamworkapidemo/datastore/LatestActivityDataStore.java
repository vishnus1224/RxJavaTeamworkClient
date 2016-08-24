package com.vishnus1224.teamworkapidemo.datastore;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;

import java.util.List;

import rx.Observable;

/**
 * Created by vishnu on 24/08/16.
 */
public interface LatestActivityDataStore {

    /**
     * Fetch the latest activity from the data store.
     * @return
     */
    Observable<List<LatestActivityResponse>> getLatestActivity();


}
