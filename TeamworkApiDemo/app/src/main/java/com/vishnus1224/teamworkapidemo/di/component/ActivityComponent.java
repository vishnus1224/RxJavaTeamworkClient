package com.vishnus1224.teamworkapidemo.di.component;

import com.vishnus1224.teamworkapidemo.di.module.ActivityModule;
import com.vishnus1224.teamworkapidemo.di.scope.PerActivity;
import com.vishnus1224.teamworkapidemo.ui.activity.LoginActivity;

import dagger.Subcomponent;

/**
 * Created by Vishnu on 8/14/2016.
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity loginActivity);
}
