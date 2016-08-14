package com.vishnus1224.teamworkapidemo.di.component;

import com.vishnus1224.teamworkapidemo.di.module.UserModule;
import com.vishnus1224.teamworkapidemo.di.scope.PerUser;
import com.vishnus1224.teamworkapidemo.ui.activity.MainActivity;

import dagger.Subcomponent;

/**
 * Created by Vishnu on 8/14/2016.
 */
@PerUser
@Subcomponent(modules = UserModule.class)
public interface UserComponent {

    void inject(MainActivity mainActivity);

}
