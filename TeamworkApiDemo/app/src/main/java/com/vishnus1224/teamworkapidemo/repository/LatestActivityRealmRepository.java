package com.vishnus1224.teamworkapidemo.repository;

import com.vishnus1224.teamworkapidemo.mapper.RealmResultToListMapper;
import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;

/**
 * Created by Vishnu on 8/29/2016.
 */
public class LatestActivityRealmRepository implements BaseRepository<LatestActivityModel> {

    private Realm realm;

    private RealmResultToListMapper realmResultToListMapper;

    @Inject
    public LatestActivityRealmRepository(Realm realm, RealmResultToListMapper realmResultToListMapper) {

        this.realm = realm;

        this.realmResultToListMapper = realmResultToListMapper;

    }

    @Override
    public void add(LatestActivityModel latestActivityModel) {

    }

    @Override
    public void allAll(List<LatestActivityModel> latestActivityModels) {

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

        RealmResults<LatestActivityModel> realmResults = realm.where(LatestActivityModel.class).findAll();

        return Observable.just(realmResultToListMapper.map(realmResults));

    }
}
