package com.vishnus1224.teamworkapidemo.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.RealmModel;
import io.realm.RealmResults;

/**
 * Created by Vishnu on 8/29/2016.
 */
public class RealmResultToListMapper<T extends RealmModel> implements Mapper<RealmResults<T>, List<T>> {

    @Inject
    public RealmResultToListMapper() {
    }

    @Override
    public List<T> map(RealmResults<T> ts) {

        List<T> list = new ArrayList<>(ts.size());

        list.addAll(ts);

        return list;
    }
}
