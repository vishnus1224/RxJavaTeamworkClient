package com.vishnus1224.teamworkapidemo.repository;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;
import com.vishnus1224.teamworkapidemo.datastore.LatestActivityDataStore;
import com.vishnus1224.teamworkapidemo.mapper.LatestActivityResponseToModelMapper;
import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by vishnu on 24/08/16.
 */
public class LatestActivityCloudRepository implements BaseRepository<LatestActivityModel> {

    private LatestActivityDataStore latestActivityDataStore;

    private LatestActivityResponseToModelMapper latestActivityResponseToModelMapper;

    @Inject
    public LatestActivityCloudRepository(@Named("activityCloudDataStore") LatestActivityDataStore latestActivityDataStore, LatestActivityResponseToModelMapper latestActivityResponseToModelMapper) {

        this.latestActivityDataStore = latestActivityDataStore;

        this.latestActivityResponseToModelMapper = latestActivityResponseToModelMapper;

    }

    @Override
    public void add(LatestActivityModel LatestActivityModel) {

    }

    @Override
    public LatestActivityModel removeItem() {
        return null;
    }

    @Override
    public Observable<LatestActivityModel> getItem() {
        return null;
    }

    @Override
    public Observable<List<LatestActivityModel>> getAllItems() {

        return latestActivityDataStore.getLatestActivity()
                .flatMap(new Func1<List<LatestActivityResponse>, Observable<List<LatestActivityModel>>>() {
                    @Override
                    public Observable<List<LatestActivityModel>> call(List<LatestActivityResponse> latestActivityResponses) {

                        List<LatestActivityModel> latestActivityModelList = new ArrayList<>(latestActivityResponses.size());

                        for(LatestActivityResponse latestActivityResponse : latestActivityResponses){

                            latestActivityModelList.add(latestActivityResponseToModelMapper.map(latestActivityResponse));

                        }

                        return Observable.just(latestActivityModelList);
                    }

                });

    }

}
