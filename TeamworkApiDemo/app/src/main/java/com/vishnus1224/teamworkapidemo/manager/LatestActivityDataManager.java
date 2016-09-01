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
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by vishnu on 31/08/16.
 */
public class LatestActivityDataManager implements DataManager<LatestActivityDto> {

    private Subject<List<LatestActivityDto>, List<LatestActivityDto>> subject =
            new SerializedSubject<>(PublishSubject.<List<LatestActivityDto>>create());


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

        subject.observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);

        latestActivityRealmRepository.getAllItems()
                .subscribeOn(Schedulers.io())
                .subscribe(new LatestActivityDatabaseSubscriber(subject));

        latestActivityRepository.getAllItems()
                .doOnNext(new Action1<List<LatestActivityModel>>() {
                    @Override
                    public void call(List<LatestActivityModel> latestActivityModels) {

                        latestActivityRealmRepository.addAll(latestActivityModels);

                        latestActivityRealmRepository.getAllItems().subscribe(subject);


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

    @Override
    public void searchItems(String queryString, Subscriber<List<LatestActivityDto>> subscriber) {

        latestActivityRealmRepository.searchItems(queryString)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }


}
