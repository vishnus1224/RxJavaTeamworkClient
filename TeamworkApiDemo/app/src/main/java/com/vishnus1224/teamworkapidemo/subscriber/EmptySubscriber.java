package com.vishnus1224.teamworkapidemo.subscriber;

import rx.Subscriber;

/**
 * Empty subscriber for just triggering the observable.
 * Created by vishnu on 02/09/16.
 */
public class EmptySubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }
}
