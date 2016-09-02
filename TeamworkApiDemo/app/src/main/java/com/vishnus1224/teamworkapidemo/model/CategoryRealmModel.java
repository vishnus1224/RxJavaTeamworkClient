package com.vishnus1224.teamworkapidemo.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by vishnu on 02/09/16.
 */
public class CategoryRealmModel extends RealmObject {

    public String name;

    @PrimaryKey
    public String id;
}
