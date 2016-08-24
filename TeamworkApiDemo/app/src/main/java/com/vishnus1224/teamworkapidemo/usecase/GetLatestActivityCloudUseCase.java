package com.vishnus1224.teamworkapidemo.usecase;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;
import com.vishnus1224.teamworkapidemo.di.scope.PerFragment;
import com.vishnus1224.teamworkapidemo.repository.BaseRepository;
import com.vishnus1224.teamworkapidemo.repository.LatestActivityRepository;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;

/**
 * Get the latest activity from the cloud.
 * Created by vishnu on 24/08/16.
 */
public class GetLatestActivityCloudUseCase extends UseCase {

    private BaseRepository repository;

    @Inject
    public GetLatestActivityCloudUseCase(@Named("activityRepo") BaseRepository repository){

        this.repository = repository;

    }

    @Override
    Observable buildUseCase() {

        return Observable.just(repository.getAllItems());

    }
}
