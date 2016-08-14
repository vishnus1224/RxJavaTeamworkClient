package com.vishnus1224.teamworkapidemo.di.component;

import com.vishnus1224.teamworkapidemo.TeamworkApiDemo;
import com.vishnus1224.teamworkapidemo.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Vishnu on 8/13/2016.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(TeamworkApiDemo teamworkApiDemo);

}