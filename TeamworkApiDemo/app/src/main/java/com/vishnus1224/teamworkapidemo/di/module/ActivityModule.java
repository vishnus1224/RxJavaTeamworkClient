package com.vishnus1224.teamworkapidemo.di.module;

import android.app.Activity;

import com.vishnus1224.teamworkapidemo.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Vishnu on 8/14/2016.
 */
@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides @PerActivity
    Activity provideActivity(){

        return activity;

    }
}
