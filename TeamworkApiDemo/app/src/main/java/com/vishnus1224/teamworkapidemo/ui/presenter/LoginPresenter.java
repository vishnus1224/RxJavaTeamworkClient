package com.vishnus1224.teamworkapidemo.ui.presenter;

import com.vishnus1224.rxjavateamworkclient.model.AccountResponse;
import com.vishnus1224.teamworkapidemo.di.scope.PerActivity;
import com.vishnus1224.teamworkapidemo.ui.view.LoginView;
import com.vishnus1224.teamworkapidemo.usecase.UseCase;

import java.net.UnknownHostException;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscriber;

/**
 * Created by Vishnu on 8/14/2016.
 */
@PerActivity
public class LoginPresenter implements BasePresenter<LoginView> {

    private UseCase useCase;

    private LoginView loginView;

    @Inject
    public LoginPresenter(@Named("authentication") UseCase useCase) {

        this.useCase = useCase;

    }

    @Override
    public void onViewAttached(LoginView loginView) {

        this.loginView = loginView;

    }

    @Override
    public void onViewDetached(LoginView loginView) {

        useCase.unSubscribe();

        this.loginView = null;

    }

    public void loginUser() {

        loginView.showProgressDialog();

        useCase.execute(new Subscriber<AccountResponse>() {

            @Override
            public void onCompleted() {

                hideProgressDialog();

            }

            @Override
            public void onError(Throwable e) {

                hideProgressDialog();

                if (e instanceof UnknownHostException) {

                    loginView.showError("No Internet Connection");

                } else {

                    loginView.showError("Authorization Failed");

                }

            }

            @Override
            public void onNext(AccountResponse accountResponse) {



            }
        });

    }

    public void cancelLogin() {

        useCase.unSubscribe();

    }

    private void hideProgressDialog() {

        loginView.hideProgressDialog();

    }
}
