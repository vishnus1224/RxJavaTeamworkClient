package com.vishnus1224.teamworkapidemo;

import android.app.Application;

import com.vishnus1224.teamworkapidemo.di.component.ApplicationComponent;
import com.vishnus1224.teamworkapidemo.di.component.DaggerApplicationComponent;
import com.vishnus1224.teamworkapidemo.di.module.ApplicationModule;

/**
 * Created by Vishnu on 8/13/2016.
 */
public class TeamworkApiDemo extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        injectApplicationComponent();
    }

    private void injectApplicationComponent() {

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent(){

        return applicationComponent;

    }
}
