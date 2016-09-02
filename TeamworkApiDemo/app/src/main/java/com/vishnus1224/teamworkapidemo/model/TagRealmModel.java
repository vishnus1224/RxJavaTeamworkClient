package com.vishnus1224.teamworkapidemo.model;

import io.realm.RealmObject;

/**
 * Created by vishnu on 02/09/16.
 */
public class TagRealmModel extends RealmObject {

    public String name;

    public TagRealmModel() {
    }

    public TagRealmModel(String name) {
        this.name = name;
    }
}
