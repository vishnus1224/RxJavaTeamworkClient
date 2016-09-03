package com.vishnus1224.teamworkapidemo.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Vishnu on 9/3/2016.
 */
public class CompanyRealmModel extends RealmObject {

    public String name;

    public String isOwner;

    @PrimaryKey
    public String id;

    public CompanyRealmModel() {
    }

    public CompanyRealmModel(String name, String isOwner, String id) {
        this.name = name;
        this.isOwner = isOwner;
        this.id = id;
    }
}
