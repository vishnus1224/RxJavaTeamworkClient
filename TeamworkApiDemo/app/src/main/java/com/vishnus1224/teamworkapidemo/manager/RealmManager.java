package com.vishnus1224.teamworkapidemo.manager;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmModel;

/**
 * Handles all operations on the realm like saving data.
 * Created by Vishnu on 8/31/2016.
 */
public class RealmManager {

    private RealmConfiguration realmConfiguration;

    @Inject
    public RealmManager(RealmConfiguration realmConfiguration) {
        this.realmConfiguration = realmConfiguration;
    }

    /**
     * Provides a new instance of the realm with the set configuration.
     * @return A new instance of the realm.
     */
    public Realm newRealm(){

        return Realm.getInstance(realmConfiguration);

    }

    public <T extends RealmModel> void addToRealm(final T object){

        Realm realm = newRealm();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                realm.copyToRealmOrUpdate(object);


            }
        });

        realm.close();

    }

    public <T extends RealmModel> void addAllToRealm(final Iterable<T> objects){

        Realm realm = newRealm();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                realm.copyToRealmOrUpdate(objects);


            }
        });

        realm.close();

    }


}
