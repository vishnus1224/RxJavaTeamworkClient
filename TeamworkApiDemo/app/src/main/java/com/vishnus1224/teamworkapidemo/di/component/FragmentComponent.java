package com.vishnus1224.teamworkapidemo.di.component;

import com.vishnus1224.teamworkapidemo.di.module.FragmentModule;
import com.vishnus1224.teamworkapidemo.di.scope.PerFragment;

import dagger.Subcomponent;

/**
 * Created by vishnu on 24/08/16.
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {



}
