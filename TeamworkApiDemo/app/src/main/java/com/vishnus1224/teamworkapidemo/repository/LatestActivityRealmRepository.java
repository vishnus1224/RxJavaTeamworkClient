package com.vishnus1224.teamworkapidemo.repository;

import com.vishnus1224.teamworkapidemo.manager.RealmManager;
import com.vishnus1224.teamworkapidemo.mapper.LatestActivityDtoToModelMapper;
import com.vishnus1224.teamworkapidemo.mapper.LatestActivityModelToDtoMapper;
import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;
import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;

/**
 * Created by Vishnu on 8/29/2016.
 */
public class LatestActivityRealmRepository implements BaseRepository<LatestActivityDto> {

    private RealmManager realmManager;

    private LatestActivityModelToDtoMapper latestActivityModelToDtoMapper;

    private LatestActivityDtoToModelMapper latestActivityDtoToModelMapper;

    @Inject
    public LatestActivityRealmRepository(RealmManager realmManager, LatestActivityModelToDtoMapper latestActivityModelToDtoMapper,
                                         LatestActivityDtoToModelMapper latestActivityDtoToModelMapper) {

        this.realmManager = realmManager;

        this.latestActivityModelToDtoMapper = latestActivityModelToDtoMapper;

        this.latestActivityDtoToModelMapper = latestActivityDtoToModelMapper;

    }

    @Override
    public void add(final LatestActivityDto latestActivityDto) {

        realmManager.addToRealm(latestActivityDtoToModelMapper.map(latestActivityDto));

    }

    @Override
    public void addAll(final List<LatestActivityDto> latestActivityDtoList) {

        List<LatestActivityModel> latestActivityModelList = new ArrayList<>(latestActivityDtoList.size());

        for(LatestActivityDto latestActivityDto : latestActivityDtoList){

            latestActivityModelList.add(latestActivityDtoToModelMapper.map(latestActivityDto));

        }

        realmManager.addAllToRealm(latestActivityModelList);

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

        Realm realm = realmManager.newRealm();

        RealmResults<LatestActivityModel> realmResults = realm.where(LatestActivityModel.class).findAll();

        Observable<List<LatestActivityDto>> observable = Observable.just(latestActivityModelToDtoMapper.map(realmResults));

        realm.close();

        return observable;
    }

    @Override
    public Observable<List<LatestActivityDto>> searchItems(String searchString) {

        Realm realm = realmManager.newRealm();

        RealmResults<LatestActivityModel> realmResults = realm.where(LatestActivityModel.class)
                .contains("description", searchString, Case.INSENSITIVE)
                .or()
                .contains("fromUsername", searchString, Case.INSENSITIVE)
                .or()
                .contains("formattedDescription", searchString, Case.INSENSITIVE)
                .findAll();

        Observable<List<LatestActivityDto>> observable = Observable.just(latestActivityModelToDtoMapper.map(realmResults));

        realm.close();

        return observable;
    }
}
