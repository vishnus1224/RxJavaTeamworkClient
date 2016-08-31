package com.vishnus1224.teamworkapidemo.manager;

import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;
import com.vishnus1224.teamworkapidemo.repository.BaseRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

/**
 * Created by vishnu on 31/08/16.
 */
public class LatestActivityDataManager implements DataManager<LatestActivityModel> {

    private PublishSubject<List<LatestActivityModel>> publishSubject = PublishSubject.create();

    private BaseRepository latestActivityRepository;

    @Inject
    public LatestActivityDataManager(@Named("activityRepo") BaseRepository latestActivityRepository) {
        this.latestActivityRepository = latestActivityRepository;
    }

    @Override
    public void getAllItems(Subscriber<List<LatestActivityModel>> subscriber) {

        publishSubject.observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);

        latestActivityRepository.getAllItems().subscribeOn(Schedulers.io()).subscribe(publishSubject);

    }
}
