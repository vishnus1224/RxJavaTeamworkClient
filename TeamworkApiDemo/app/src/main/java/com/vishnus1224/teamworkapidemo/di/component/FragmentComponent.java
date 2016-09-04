package com.vishnus1224.teamworkapidemo.di.component;

import com.vishnus1224.teamworkapidemo.di.module.FragmentModule;
import com.vishnus1224.teamworkapidemo.di.scope.PerFragment;
import com.vishnus1224.teamworkapidemo.ui.fragment.LatestActivitiesFragment;
import com.vishnus1224.teamworkapidemo.ui.fragment.ProjectFragment;

import dagger.Subcomponent;

/**
 * Created by vishnu on 24/08/16.
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(LatestActivitiesFragment latestActivitiesFragment);

    void inject(ProjectFragment projectFragment);

}
