package com.vishnus1224.teamworkapidemo.di.module;

import android.app.Application;

import com.vishnus1224.rxjavateamworkclient.config.TeamworkApiConfig;
import com.vishnus1224.teamworkapidemo.BuildConfig;

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
    TeamworkApiConfig provideTeamworkApiConfig(){

        return new TeamworkApiConfig(BuildConfig.API_TOKEN, BuildConfig.API_URL);

    }
}
