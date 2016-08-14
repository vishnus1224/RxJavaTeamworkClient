package com.vishnus1224.teamworkapidemo.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.vishnus1224.rxjavateamworkclient.client.AuthenticationApiClient;
import com.vishnus1224.teamworkapidemo.manager.TokenManager;
import com.vishnus1224.teamworkapidemo.util.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Vishnu on 8/13/2016.
 */
@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application){

        this.application = application;

    }

    @Provides @Singleton
    Application provideApplication(){

        return application;

    }

    @Provides @Singleton
    TokenManager provideTokenManager(){

        return new TokenManager();

    }

    @Provides
    AuthenticationApiClient authenticationApiClient(TokenManager tokenManager){

        return new AuthenticationApiClient(tokenManager.getApiToken());

    }

    @Provides @Singleton
    SharedPreferences provideSharedPreferences(Application application){

        return application.getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);

    }
}
