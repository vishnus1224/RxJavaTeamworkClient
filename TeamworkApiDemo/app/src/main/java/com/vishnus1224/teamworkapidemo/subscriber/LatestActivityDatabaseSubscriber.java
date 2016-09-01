package com.vishnus1224.teamworkapidemo.subscriber;

import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;

import java.util.List;

import rx.Subscriber;
import rx.subjects.PublishSubject;

/**
 * Created by vishnu on 01/09/16.
 */
public class LatestActivityDatabaseSubscriber extends Subscriber<List<LatestActivityDto>> {

    private PublishSubject<List<LatestActivityDto>> publishSubject;

    public LatestActivityDatabaseSubscriber(PublishSubject<List<LatestActivityDto>> publishSubject) {
        this.publishSubject = publishSubject;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

        publishSubject.onError(e);

    }

    @Override
    public void onNext(List<LatestActivityDto> latestActivityDtoList) {

        publishSubject.onNext(latestActivityDtoList);

    }
}
