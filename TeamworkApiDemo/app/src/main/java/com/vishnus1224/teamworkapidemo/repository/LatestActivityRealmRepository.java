package com.vishnus1224.teamworkapidemo.repository;

import com.vishnus1224.teamworkapidemo.manager.RealmManager;
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

    private RealmManager realmManager;

    private RealmResultToListMapper realmResultToListMapper;

    @Inject
    public LatestActivityRealmRepository(RealmManager realmManager, RealmResultToListMapper realmResultToListMapper) {

        this.realmManager = realmManager;

        this.realmResultToListMapper = realmResultToListMapper;

    }

    @Override
    public void add(final LatestActivityModel latestActivityModel) {

        realmManager.addToRealm(latestActivityModel);

    }

    @Override
    public void addAll(final List<LatestActivityModel> latestActivityModels) {

        realmManager.addAllToRealm(latestActivityModels);

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

        Realm realm = realmManager.newRealm();

        RealmResults<LatestActivityModel> realmResults = realm.where(LatestActivityModel.class).findAll();

        Observable<List<LatestActivityModel>> observable = Observable.just(realmResultToListMapper.map(realmResults));

        return observable;
    }
}
