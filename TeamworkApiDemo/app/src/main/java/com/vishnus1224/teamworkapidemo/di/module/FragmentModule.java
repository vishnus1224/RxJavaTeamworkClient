package com.vishnus1224.teamworkapidemo.di.module;

import android.support.v4.app.Fragment;

import com.vishnus1224.rxjavateamworkclient.client.LatestActivityApiClient;
import com.vishnus1224.rxjavateamworkclient.config.TeamworkApiConfig;
import com.vishnus1224.teamworkapidemo.datastore.LatestActivityCloudDataStore;
import com.vishnus1224.teamworkapidemo.datastore.LatestActivityDataStore;
import com.vishnus1224.teamworkapidemo.datastore.LatestActivityRealmDataStore;
import com.vishnus1224.teamworkapidemo.di.scope.PerFragment;
import com.vishnus1224.teamworkapidemo.manager.DataManager;
import com.vishnus1224.teamworkapidemo.manager.LatestActivityDataManager;
import com.vishnus1224.teamworkapidemo.repository.BaseRepository;
import com.vishnus1224.teamworkapidemo.repository.LatestActivityCloudRepository;
import com.vishnus1224.teamworkapidemo.usecase.GetLatestActivityCloudUseCase;
import com.vishnus1224.teamworkapidemo.usecase.UseCase;


import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vishnu on 24/08/16.
 */
@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }


    @Provides @PerFragment
    @Named("activityCloud")
    UseCase provideLatestActivityCloudUseCase(GetLatestActivityCloudUseCase getLatestActivityCloudUseCase){

        return getLatestActivityCloudUseCase;

    }

    @Provides @PerFragment
    @Named("activityRepo")
    BaseRepository provideLatestActivityRepository(LatestActivityCloudRepository latestActivityCloudRepository){

        return latestActivityCloudRepository;

    }

    @Provides @PerFragment
    @Named("activityCloudDataStore")
    LatestActivityDataStore provideLatestActivityCloudDataStore(LatestActivityCloudDataStore latestActivityCloudDataStore){

        return latestActivityCloudDataStore;

    }

    @Provides @PerFragment
    LatestActivityApiClient provideLatestActivityApiClient(TeamworkApiConfig teamworkApiConfig){

        return new LatestActivityApiClient(teamworkApiConfig);

    }

    @Provides @PerFragment
    @Named("activityRealmDataStore")
    LatestActivityDataStore provideLatestActivityRealmDataStore(LatestActivityRealmDataStore latestActivityRealmDataStore){

        return latestActivityRealmDataStore;

    }

    @Provides @PerFragment
    @Named("activityDataManager")
    DataManager provideLatestActivityDataManager(LatestActivityDataManager latestActivityDataManager){

        return latestActivityDataManager;

    }

}
