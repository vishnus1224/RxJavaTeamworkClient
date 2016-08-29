package com.vishnus1224.teamworkapidemo.datastore;

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
public class LatestActivityRealmDataStore implements LatestActivityDataStore<LatestActivityModel> {

    private Realm realm;

    private RealmResultToListMapper realmResultToListMapper;

    @Inject
    public LatestActivityRealmDataStore(Realm realm, RealmResultToListMapper realmResultToListMapper) {

        this.realm = realm;

        this.realmResultToListMapper = realmResultToListMapper;

    }

    @Override
    public Observable<List<LatestActivityModel>> getLatestActivity() {

        RealmResults<LatestActivityModel> realmResults = realm.where(LatestActivityModel.class).findAll();

        return Observable.just(realmResultToListMapper.map(realmResults));

    }
}
