package com.vishnus1224.rxjavateamworkclient.api;

import com.vishnus1224.rxjavateamworkclient.model.AccountResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Vishnu on 8/13/2016.
 */
public interface AuthenticationApi {

    @GET("/authenticate.json")
    Observable<AccountResponse> authenticate();
}
