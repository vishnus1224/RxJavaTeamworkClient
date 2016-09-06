package com.vishnus1224.teamworkapidemo.manager;

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
 * Created by Vishnu on 9/3/2016.
 */
public class ProjectDataManager implements DataManager<ProjectDto> {

    private BaseRepository projectCloudRepository;

    private BaseRepository projectRealmRepository;

    private Subscription databaseSubscription;

    private Subscription cloudSubscription;


    @Inject
    public ProjectDataManager(@Named("projectCloudRepo") BaseRepository projectCloudRepository,
                              @Named("projectRealmRepo") BaseRepository projectRealmRepository) {

        this.projectCloudRepository = projectCloudRepository;
        this.projectRealmRepository = projectRealmRepository;

    }

    @Override
    public void getAllItems(Subscriber<List<ProjectDto>> databaseSubscriber, final Subscriber<List<ProjectDto>> cloudSubscriber) {

        final Observable<List<ProjectDto>> cloudObservable = projectCloudRepository.getAllItems()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Action1<List<ProjectDto>>() {
                    @Override
                    public void call(List<ProjectDto> projectDtoList) {

                        projectRealmRepository.addAll(projectDtoList);

                        cloudSubscription = projectRealmRepository.getAllItems().subscribe(cloudSubscriber);

                    }

                }).doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                        cloudSubscriber.onError(throwable);

                    }
                });

        databaseSubscription = projectRealmRepository.getAllItems()
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
    public void searchItems(String queryString, Subscriber<List<ProjectDto>> subscriber) {

        projectRealmRepository.searchItems(queryString)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

    @Override
    public void unSubscribe() {

        unSubscribeIfNotAlreadyDone(databaseSubscription);

        unSubscribeIfNotAlreadyDone(cloudSubscription);

    }

    private void unSubscribeIfNotAlreadyDone(Subscription subscription) {

        if(subscription != null && !subscription.isUnsubscribed()){

            subscription.unsubscribe();

        }

    }
}
