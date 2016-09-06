package com.vishnus1224.teamworkapidemo.manager;

import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;
import com.vishnus1224.teamworkapidemo.model.ProjectDto;
import com.vishnus1224.teamworkapidemo.repository.BaseRepository;
import com.vishnus1224.teamworkapidemo.subscriber.EmptySubscriber;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by vishnu on 31/08/16.
 */
public class LatestActivityDataManager implements DataManager<LatestActivityDto> {

    private BaseRepository latestActivityRepository;

    private BaseRepository latestActivityRealmRepository;

    @Inject
    public LatestActivityDataManager(@Named("activityRepo") BaseRepository latestActivityRepository,
                                     @Named("activityRealmRepo") BaseRepository latestActivityRealmRepository) {
        this.latestActivityRepository = latestActivityRepository;

        this.latestActivityRealmRepository = latestActivityRealmRepository;
    }

    @Override
    public void getAllItems(Subscriber<List<LatestActivityDto>> databaseSubscriber, final Subscriber<List<LatestActivityDto>> cloudSubscriber) {

        final Observable<List<ProjectDto>> cloudObservable = latestActivityRepository.getAllItems()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Action1<List<LatestActivityDto>>() {
                    @Override
                    public void call(List<LatestActivityDto> latestActivityModels) {

                        latestActivityRealmRepository.addAll(latestActivityModels);

                        latestActivityRealmRepository.getAllItems().subscribe(cloudSubscriber);


                    }
                }).doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                        cloudSubscriber.onError(throwable);

                    }
                });

        latestActivityRealmRepository.getAllItems()
                .doOnCompleted(new Action0() {
                    @Override
                    public void call() {

                        cloudObservable.subscribe(new EmptySubscriber<List<ProjectDto>>());

                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(databaseSubscriber);


    }

    @Override
    public void searchItems(String queryString, Subscriber<List<LatestActivityDto>> subscriber) {

        latestActivityRealmRepository.searchItems(queryString)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

    @Override
    public void unSubscribe() {


    }

    private void unSubscribeIfNotAlreadyDone(Subscription subscription){

        if(subscription != null && !subscription.isUnsubscribed()){

            subscription.unsubscribe();

        }

    }


}
