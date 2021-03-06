package com.vishnus1224.teamworkapidemo.di.module;

import android.support.v4.app.Fragment;

import com.vishnus1224.rxjavateamworkclient.client.LatestActivityApiClient;
import com.vishnus1224.rxjavateamworkclient.client.ProjectApiClient;
import com.vishnus1224.rxjavateamworkclient.config.TeamworkApiConfig;
import com.vishnus1224.teamworkapidemo.datastore.LatestActivityCloudDataStore;
import com.vishnus1224.teamworkapidemo.datastore.DataStore;
import com.vishnus1224.teamworkapidemo.datastore.ProjectCloudDataStore;
import com.vishnus1224.teamworkapidemo.di.scope.PerFragment;
import com.vishnus1224.teamworkapidemo.manager.DataManager;
import com.vishnus1224.teamworkapidemo.manager.LatestActivityDataManager;
import com.vishnus1224.teamworkapidemo.manager.ProjectDataManager;
import com.vishnus1224.teamworkapidemo.repository.BaseRepository;
import com.vishnus1224.teamworkapidemo.repository.LatestActivityCloudRepository;
import com.vishnus1224.teamworkapidemo.repository.LatestActivityRealmRepository;
import com.vishnus1224.teamworkapidemo.repository.ProjectCloudRepository;
import com.vishnus1224.teamworkapidemo.repository.ProjectRealmRepository;


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
    @Named("activityRepo")
    BaseRepository provideLatestActivityRepository(LatestActivityCloudRepository latestActivityCloudRepository){

        return latestActivityCloudRepository;

    }

    @Provides @PerFragment
    @Named("activityCloudDataStore")
    DataStore provideLatestActivityCloudDataStore(LatestActivityCloudDataStore latestActivityCloudDataStore){

        return latestActivityCloudDataStore;

    }

    @Provides @PerFragment
    LatestActivityApiClient provideLatestActivityApiClient(TeamworkApiConfig teamworkApiConfig){

        return new LatestActivityApiClient(teamworkApiConfig);

    }

    @Provides @PerFragment
    @Named("activityDataManager")
    DataManager provideLatestActivityDataManager(LatestActivityDataManager latestActivityDataManager){

        return latestActivityDataManager;

    }

    @Provides @PerFragment
    @Named("activityRealmRepo")
    BaseRepository provideLatestActivityRealmRepository(LatestActivityRealmRepository latestActivityRealmRepository){

        return latestActivityRealmRepository;

    }

    @Provides @PerFragment
    ProjectApiClient provideProjectApiClient(TeamworkApiConfig teamworkApiConfig){

        return new ProjectApiClient(teamworkApiConfig);

    }

    @Provides @PerFragment @Named("projectCloudDataStore")
    DataStore provideProjectCloudDataStore(ProjectCloudDataStore projectCloudDataStore){

        return projectCloudDataStore;

    }

    @Provides @PerFragment @Named("projectCloudRepo")
    BaseRepository provideProjectCloudRepository(ProjectCloudRepository projectCloudRepository){

        return projectCloudRepository;

    }

    @Provides @PerFragment @Named("projectRealmRepo")
    BaseRepository provideProjectRealmRepository(ProjectRealmRepository projectRealmRepository){

        return projectRealmRepository;

    }

    @Provides @PerFragment @Named("projectDataManager")
    DataManager provideProjectDataManager(ProjectDataManager projectDataManager){

        return projectDataManager;

    }
}
