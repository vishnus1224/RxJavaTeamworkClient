package com.vishnus1224.teamworkapidemo.usecase;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Base class for a single use case.
 * Created by Vishnu on 8/14/2016.
 */
public abstract class UseCase {

    abstract Observable buildUseCase();

    private Subscription subscription;

    public void execute(Subscriber subscriber){

        subscription = buildUseCase().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(subscriber);

    }

    public void unSubscribe(){

        if(subscription != null && !subscription.isUnsubscribed()){

            subscription.unsubscribe();

        }

    }
}
