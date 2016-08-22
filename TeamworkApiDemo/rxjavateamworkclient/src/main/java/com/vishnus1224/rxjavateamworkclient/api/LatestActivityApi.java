package com.vishnus1224.rxjavateamworkclient.api;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Vishnu on 8/22/2016.
 */
public interface LatestActivityApi {

    @GET("/latestActivity.json")
    Observable<List<LatestActivityResponse>> getLatestActivity();
}
