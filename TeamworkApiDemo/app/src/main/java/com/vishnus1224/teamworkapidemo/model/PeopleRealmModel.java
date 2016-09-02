package com.vishnus1224.teamworkapidemo.model;

import io.realm.RealmObject;

/**
 * Created by vishnu on 02/09/16.
 */
public class PeopleRealmModel extends RealmObject {

    public String id;

    public PeopleRealmModel() {
    }

    public PeopleRealmModel(String id) {
        this.id = id;
    }
}
