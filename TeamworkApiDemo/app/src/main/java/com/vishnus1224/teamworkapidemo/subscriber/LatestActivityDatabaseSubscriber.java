package com.vishnus1224.teamworkapidemo.subscriber;

import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;

import java.util.List;

import rx.Subscriber;
import rx.subjects.Subject;

/**
 * Created by vishnu on 01/09/16.
 */
public class LatestActivityDatabaseSubscriber extends Subscriber<List<LatestActivityDto>> {

    private Subject<List<LatestActivityDto>, List<LatestActivityDto>> subject;

    public LatestActivityDatabaseSubscriber(Subject<List<LatestActivityDto>, List<LatestActivityDto>> subject) {
        this.subject = subject;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

        subject.onError(e);

    }

    @Override
    public void onNext(List<LatestActivityDto> latestActivityDtoList) {

        subject.onNext(latestActivityDtoList);

    }
}
