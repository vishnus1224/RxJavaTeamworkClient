package com.vishnus1224.teamworkapidemo.datastore;

import java.util.List;

import rx.Observable;

/**
 * Created by vishnu on 24/08/16.
 */
public interface LatestActivityDataStore<DataType> {

    /**
     * Fetch the latest activity from the data store.
     * @return
     */
    Observable<List<DataType>> getLatestActivity();


}
