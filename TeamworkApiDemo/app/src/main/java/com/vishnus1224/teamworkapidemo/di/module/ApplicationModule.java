package com.vishnus1224.teamworkapidemo.di.module;

import android.app.Application;

import com.vishnus1224.rxjavateamworkclient.client.AuthenticationApiClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Vishnu on 8/13/2016.
 */
@Module
public class ApplicationModule {

    private Application application;

    private String apiToken;

    public ApplicationModule(Application application, String apiToken){

        this.application = application;

        this.apiToken = apiToken;
    }

    @Provides @Singleton
    Application provideApplication(){

        return application;

    }

    @Provides @Singleton
    AuthenticationApiClient authenticationApiClient(){

        return new AuthenticationApiClient(apiToken);

    }
}
