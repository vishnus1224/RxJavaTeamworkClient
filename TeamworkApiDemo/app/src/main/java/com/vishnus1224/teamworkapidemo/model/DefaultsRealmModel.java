package com.vishnus1224.teamworkapidemo.model;

import io.realm.RealmObject;

/**
 * Created by Vishnu on 9/3/2016.
 */
public class DefaultsRealmModel extends RealmObject {

    public String privacy;

    public DefaultsRealmModel() {
    }

    public DefaultsRealmModel(String privacy) {
        this.privacy = privacy;
    }
}
