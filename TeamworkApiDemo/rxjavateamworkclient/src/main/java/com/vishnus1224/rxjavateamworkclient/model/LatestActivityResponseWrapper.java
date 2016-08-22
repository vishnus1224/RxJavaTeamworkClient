package com.vishnus1224.rxjavateamworkclient.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

/**
 * Created by Vishnu on 8/22/2016.
 */
@JsonObject
public class LatestActivityResponseWrapper  extends BaseResponse {

    @JsonField(name = "activity")
    private List<LatestActivityResponse> latestActivityResponseList;

    public List<LatestActivityResponse> getLatestActivityResponseList() {
        return latestActivityResponseList;
    }

    public void setLatestActivityResponseList(List<LatestActivityResponse> latestActivityResponseList) {
        this.latestActivityResponseList = latestActivityResponseList;
    }
}
