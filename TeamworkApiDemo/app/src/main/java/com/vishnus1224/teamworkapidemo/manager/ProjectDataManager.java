package com.vishnus1224.teamworkapidemo.manager;

import com.vishnus1224.teamworkapidemo.model.ProjectDto;
import com.vishnus1224.teamworkapidemo.repository.BaseRepository;
import com.vishnus1224.teamworkapidemo.subscriber.EmptySubscriber;
import com.vishnus1224.teamworkapidemo.subscriber.ProjectDatabaseSubscriber;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/**
 * Created by Vishnu on 9/3/2016.
 */
public class ProjectDataManager implements DataManager<ProjectDto> {

    private SerializedSubject<List<ProjectDto>, List<ProjectDto>> serializedSubject =
            new SerializedSubject<>(PublishSubject.<List<ProjectDto>>create());

    private BaseRepository projectCloudRepository;

    private BaseRepository projectRealmRepository;

    private Subscription subjectSubscription;

    private Subscription databaseSubscription;

    private Subscription cloudSubscription;

    @Inject
    public ProjectDataManager(@Named("projectCloudRepo") BaseRepository projectCloudRepository,
                              @Named("projectRealmRepo") BaseRepository projectRealmRepository) {

        this.projectCloudRepository = projectCloudRepository;
        this.projectRealmRepository = projectRealmRepository;

    }

    @Override
    public void getAllItems(Subscriber<List<ProjectDto>> subscriber) {

        subjectSubscription = serializedSubject.observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

        databaseSubscription = projectRealmRepository.getAllItems()
                .subscribeOn(Schedulers.io())
                .subscribe(new ProjectDatabaseSubscriber(serializedSubject));

        cloudSubscription = projectCloudRepository.getAllItems()
                .doOnNext(new Action1<List<ProjectDto>>() {
                    @Override
                    public void call(List<ProjectDto> projectDtoList) {

                        projectRealmRepository.addAll(projectDtoList);

                        databaseSubscription = projectRealmRepository.getAllItems().subscribe(serializedSubject);

                    }

                })
                .subscribeOn(Schedulers.io())
                .subscribe(new EmptySubscriber<List<ProjectDto>>());

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

        unSubscribeIfNotAlreadyDone(subjectSubscription);

        unSubscribeIfNotAlreadyDone(databaseSubscription);

        unSubscribeIfNotAlreadyDone(cloudSubscription);

    }

    private void unSubscribeIfNotAlreadyDone(Subscription subscription) {

        if(subscription != null && !subscription.isUnsubscribed()){

            subscription.unsubscribe();

        }

    }
}
