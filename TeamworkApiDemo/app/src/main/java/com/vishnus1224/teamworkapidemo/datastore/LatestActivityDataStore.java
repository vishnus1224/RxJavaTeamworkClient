package com.vishnus1224.teamworkapidemo.datastore;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;

import java.util.List;

/**
 * Created by vishnu on 24/08/16.
 */
public interface LatestActivityDataStore {

    /**
     * Fetch the latest activity from the data store.
     * @return
     */
    List<LatestActivityResponse> getLatestActivity();


}
