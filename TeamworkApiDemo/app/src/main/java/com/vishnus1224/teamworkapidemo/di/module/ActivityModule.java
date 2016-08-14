package com.vishnus1224.teamworkapidemo.di.module;

import android.app.Activity;

import com.vishnus1224.teamworkapidemo.di.scope.PerActivity;
import com.vishnus1224.teamworkapidemo.usecase.AuthenticationUseCase;
import com.vishnus1224.teamworkapidemo.usecase.UseCase;

import javax.inject.Named;

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

    @Provides @PerActivity @Named("authentication")
    UseCase provideAuthenticationUseCase(AuthenticationUseCase authenticationUseCase){

        return authenticationUseCase;

    }
}
