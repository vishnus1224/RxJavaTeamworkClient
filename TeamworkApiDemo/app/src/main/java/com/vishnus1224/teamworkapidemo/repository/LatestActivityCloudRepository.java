package com.vishnus1224.teamworkapidemo.repository;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;
import com.vishnus1224.teamworkapidemo.datastore.DataStore;
import com.vishnus1224.teamworkapidemo.mapper.LatestActivityResponseToDtoMapper;
import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by vishnu on 24/08/16.
 */
public class LatestActivityCloudRepository implements BaseRepository<LatestActivityDto> {

    private DataStore dataStore;

    private LatestActivityResponseToDtoMapper latestActivityResponseToDtoMapper;

    @Inject
    public LatestActivityCloudRepository(@Named("activityCloudDataStore") DataStore dataStore, LatestActivityResponseToDtoMapper latestActivityResponseToDtoMapper) {

        this.dataStore = dataStore;

        this.latestActivityResponseToDtoMapper = latestActivityResponseToDtoMapper;

    }

    @Override
    public void add(LatestActivityDto latestActivityDto) {

    }

    @Override
    public void addAll(List<LatestActivityDto> latestActivityDtoList) {

    }

    @Override
    public LatestActivityDto removeItem() {
        return null;
    }

    @Override
    public Observable<LatestActivityDto> getItem() {
        return null;
    }

    @Override
    public Observable<List<LatestActivityDto>> getAllItems() {

        return dataStore.getLatestActivity()
                .flatMap(new Func1<List<LatestActivityResponse>, Observable<List<LatestActivityDto>>>() {
                    @Override
                    public Observable<List<LatestActivityDto>> call(List<LatestActivityResponse> latestActivityResponses) {

                        List<LatestActivityDto> latestActivityDtoList = new ArrayList<>(latestActivityResponses.size());

                        for(LatestActivityResponse latestActivityResponse : latestActivityResponses){

                            latestActivityDtoList.add(latestActivityResponseToDtoMapper.map(latestActivityResponse));

                        }

                        return Observable.just(latestActivityDtoList);
                    }

                });

    }

    @Override
    public Observable<List<LatestActivityDto>> searchItems(String searchString) {
        return null;
    }

}
