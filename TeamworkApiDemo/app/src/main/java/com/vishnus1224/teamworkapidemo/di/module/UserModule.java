package com.vishnus1224.teamworkapidemo.di.module;

import com.vishnus1224.rxjavateamworkclient.client.LatestActivityApiClient;
import com.vishnus1224.rxjavateamworkclient.config.TeamworkApiConfig;
import com.vishnus1224.teamworkapidemo.datastore.LatestActivityCloudDataStore;
import com.vishnus1224.teamworkapidemo.datastore.LatestActivityDataStore;
import com.vishnus1224.teamworkapidemo.datastore.LatestActivityRealmDataStore;
import com.vishnus1224.teamworkapidemo.di.scope.PerUser;
import com.vishnus1224.teamworkapidemo.repository.BaseRepository;
import com.vishnus1224.teamworkapidemo.repository.LatestActivityRepository;
import com.vishnus1224.teamworkapidemo.usecase.GetLatestActivityCloudUseCase;
import com.vishnus1224.teamworkapidemo.usecase.UseCase;

import javax.inject.Named;

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

    @Provides @PerUser
    @Named("activityCloud")
    UseCase provideLatestActivityCloudUseCase(GetLatestActivityCloudUseCase getLatestActivityCloudUseCase){

        return getLatestActivityCloudUseCase;

    }

    @Provides @PerUser
    @Named("activityRepo")
    BaseRepository provideLatestActivityRepository(LatestActivityRepository latestActivityRepository){

        return latestActivityRepository;

    }

    @Provides @PerUser
    @Named("activityCloudDataStore")
    LatestActivityDataStore provideLatestActivityCloudDataStore(LatestActivityCloudDataStore latestActivityCloudDataStore){

        return latestActivityCloudDataStore;

    }

    @Provides @PerUser
    LatestActivityApiClient provideLatestActivityApiClient(TeamworkApiConfig teamworkApiConfig){

        return new LatestActivityApiClient(teamworkApiConfig);

    }

    @Provides @PerUser
    @Named("activityRealmDataStore")
    LatestActivityDataStore provideLatestActivityRealmDataStore(LatestActivityRealmDataStore latestActivityRealmDataStore){

        return latestActivityRealmDataStore;

    }
}
