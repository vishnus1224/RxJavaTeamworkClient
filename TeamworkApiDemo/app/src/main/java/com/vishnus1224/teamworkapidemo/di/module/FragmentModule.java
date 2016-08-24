package com.vishnus1224.teamworkapidemo.di.module;

import android.support.v4.app.Fragment;

import dagger.Module;

/**
 * Created by vishnu on 24/08/16.
 */
@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }


}
