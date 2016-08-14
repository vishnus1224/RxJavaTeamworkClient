package com.vishnus1224.teamworkapidemo.di.module;

import com.vishnus1224.rxjavateamworkclient.config.TeamworkApiConfig;
import com.vishnus1224.teamworkapidemo.di.scope.PerUser;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Vishnu on 8/14/2016.
 */
@Module
public class UserModule {

    private TeamworkApiConfig teamworkApiConfig;

    public UserModule(TeamworkApiConfig teamworkApiConfig){

        this.teamworkApiConfig = teamworkApiConfig;

    }

    @Provides @PerUser
    TeamworkApiConfig provideTeamworkApiConfig(){

        return teamworkApiConfig;

    }
}
