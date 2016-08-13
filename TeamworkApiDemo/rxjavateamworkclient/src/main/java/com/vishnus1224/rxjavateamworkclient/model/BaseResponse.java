package com.vishnus1224.rxjavateamworkclient.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by Vishnu on 8/13/2016.
 */
@JsonObject
class BaseResponse {

    @JsonField
    protected String STATUS;

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
}
