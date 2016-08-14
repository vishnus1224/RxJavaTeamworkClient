package com.vishnus1224.teamworkapidemo.ui.presenter;

import com.vishnus1224.teamworkapidemo.di.scope.PerActivity;
import com.vishnus1224.teamworkapidemo.ui.view.LoginView;

import javax.inject.Inject;

/**
 * Created by Vishnu on 8/14/2016.
 */
@PerActivity
public class LoginPresenter implements BasePresenter<LoginView> {

    private LoginView loginView;

    @Inject
    public LoginPresenter(){

    }

    @Override
    public void onViewAttached(LoginView loginView) {

        this.loginView = loginView;
    }

    @Override
    public void onViewDetached(LoginView loginView) {

        this.loginView = null;

    }

    public void loginUser(){



    }
}
