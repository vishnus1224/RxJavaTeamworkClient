package com.vishnus1224.teamworkapidemo.manager;

import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;
import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;
import com.vishnus1224.teamworkapidemo.repository.BaseRepository;
import com.vishnus1224.teamworkapidemo.subscriber.LatestActivityDatabaseSubscriber;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

/**
 * Created by vishnu on 31/08/16.
 */
public class LatestActivityDataManager implements DataManager<LatestActivityDto> {

    private PublishSubject<List<LatestActivityDto>> publishSubject = PublishSubject.create();

    private BaseRepository latestActivityRepository;

    private BaseRepository latestActivityRealmRepository;

    @Inject
    public LatestActivityDataManager(@Named("activityRepo") BaseRepository latestActivityRepository,
                                     @Named("activityRealmRepo") BaseRepository latestActivityRealmRepository) {
        this.latestActivityRepository = latestActivityRepository;

        this.latestActivityRealmRepository = latestActivityRealmRepository;
    }

    @Override
    public void getAllItems(Subscriber<List<LatestActivityDto>> subscriber) {

        publishSubject.observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);

        latestActivityRealmRepository.getAllItems()
                .subscribeOn(Schedulers.io())
                .subscribe(new LatestActivityDatabaseSubscriber(publishSubject));

        latestActivityRepository.getAllItems()
                .doOnNext(new Action1<List<LatestActivityModel>>() {
                    @Override
                    public void call(List<LatestActivityModel> latestActivityModels) {

                        latestActivityRealmRepository.addAll(latestActivityModels);

                        latestActivityRealmRepository.getAllItems().subscribe(publishSubject);


                    }
                })
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<LatestActivityDto>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<LatestActivityDto> latestActivityModels) {

                    }
                });

    }
}
