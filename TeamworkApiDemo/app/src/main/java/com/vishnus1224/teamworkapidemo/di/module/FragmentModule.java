package com.vishnus1224.teamworkapidemo.di.module;

import android.support.v4.app.Fragment;

import com.vishnus1224.teamworkapidemo.di.scope.PerFragment;
import com.vishnus1224.teamworkapidemo.mapper.Mapper;
import com.vishnus1224.teamworkapidemo.mapper.RealmResultToListMapper;
import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;

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

    @Provides @PerFragment @Named("realmResultToList")
    Mapper provideMapper(RealmResultToListMapper<LatestActivityModel> realmResultToListMapper){

        return realmResultToListMapper;

    }

}
