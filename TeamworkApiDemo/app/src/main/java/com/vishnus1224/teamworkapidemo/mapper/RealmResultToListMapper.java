package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.RealmResults;

/**
 * Created by Vishnu on 8/29/2016.
 */
public class RealmResultToListMapper implements Mapper<RealmResults<LatestActivityModel>, List<LatestActivityModel>> {

    @Inject
    public RealmResultToListMapper() {

    }


    @Override
    public List<LatestActivityModel> map(RealmResults<LatestActivityModel> latestActivityModels) {

        List<LatestActivityModel> list = new ArrayList<>(latestActivityModels.size());

        list.addAll(latestActivityModels);

        return list;
    }
}
