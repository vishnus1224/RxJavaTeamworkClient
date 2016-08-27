package com.vishnus1224.rxjavateamworkclient.model;

import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by Vishnu on 8/27/2016.
 */
@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS_AND_ACCESSORS)
public class Category {

    private String name;

    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
