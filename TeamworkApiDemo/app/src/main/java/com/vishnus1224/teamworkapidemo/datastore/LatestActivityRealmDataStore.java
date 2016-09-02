package com.vishnus1224.teamworkapidemo.datastore;

import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;

/**
 * Created by Vishnu on 8/29/2016.
 */
public class LatestActivityRealmDataStore implements DataStore<LatestActivityModel> {

    private Realm realm;

    @Inject
    public LatestActivityRealmDataStore(Realm realm) {

        this.realm = realm;

    }

    @Override
    public Observable<List<LatestActivityModel>> getAllItems() {

        RealmResults<LatestActivityModel> realmResults = realm.where(LatestActivityModel.class).findAll();

        List<LatestActivityModel> latestActivityModelList = new ArrayList<>(realmResults.size());

        latestActivityModelList.addAll(realmResults);

        return Observable.just(latestActivityModelList);

    }
}
