package com.vishnus1224.teamworkapidemo.usecase;

import com.vishnus1224.rxjavateamworkclient.client.AuthenticationApiClient;

import javax.inject.Inject;
import javax.inject.Provider;

import rx.Observable;

/**
 * Created by Vishnu on 8/14/2016.
 */
public class AuthenticationUseCase extends UseCase {

    private Provider<AuthenticationApiClient> authenticationApiClient;

    @Inject
    public AuthenticationUseCase(Provider<AuthenticationApiClient> authenticationApiClient){

        this.authenticationApiClient = authenticationApiClient;

    }

    @Override
    Observable buildUseCase() {

        return authenticationApiClient.get().authenticate();

    }
}
