package com.vishnus1224.teamworkapidemo.manager;

import java.util.List;

import rx.Subscriber;

/**
 * Created by vishnu on 31/08/16.
 */
public interface DataManager<Type> {

    void getAllItems(Subscriber<List<Type>> subscriber);

    void searchItems(String queryString, Subscriber<List<Type>> subscriber);

    void unSubscribe();

}
