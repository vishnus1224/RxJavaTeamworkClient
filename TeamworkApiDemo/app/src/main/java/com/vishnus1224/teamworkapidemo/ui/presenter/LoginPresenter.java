package com.vishnus1224.teamworkapidemo.ui.presenter;

import com.vishnus1224.rxjavateamworkclient.model.Account;
import com.vishnus1224.rxjavateamworkclient.model.AccountResponse;
import com.vishnus1224.teamworkapidemo.di.scope.PerActivity;
import com.vishnus1224.teamworkapidemo.manager.PreferencesManager;
import com.vishnus1224.teamworkapidemo.manager.TokenManager;
import com.vishnus1224.teamworkapidemo.ui.view.LoginView;
import com.vishnus1224.teamworkapidemo.usecase.UseCase;
import com.vishnus1224.teamworkapidemo.util.Constants;

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

    private PreferencesManager preferencesManager;

    private TokenManager tokenManager;

    @Inject
    public LoginPresenter(@Named("authentication") UseCase useCase, PreferencesManager preferencesManager,
                          TokenManager tokenManager) {

        this.useCase = useCase;

        this.preferencesManager = preferencesManager;

        this.tokenManager = tokenManager;
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

    /**
     * Attempt to authenticate the user.
     * @param apiToken api token entered by the user.
     */
    public void loginUser(String apiToken) {

        loginView.showProgressDialog();

        setToken(apiToken);

        useCase.execute(new Subscriber<AccountResponse>() {

            @Override
            public void onCompleted() {


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

                saveTokenToPrefs();

                saveUrlToPrefs(accountResponse.getAccount());

                hideProgressDialog();

                loginView.goToMainScreen(accountResponse.getAccount());


            }
        });

    }

    /**
     * Cancel the authentication flow.
     */
    public void cancelLogin() {

        useCase.unSubscribe();

    }


    private void setToken(String apiToken) {

        tokenManager.setApiToken(apiToken);

    }

    private void saveUrlToPrefs(Account account) {

        preferencesManager.save(Constants.PREFS_KEY_SITE_URL, account.getURL());

    }

    private void saveTokenToPrefs() {

        preferencesManager.save(Constants.PREFS_KEY_API_TOKEN, tokenManager.getApiToken());

    }

    private void hideProgressDialog() {

        loginView.hideProgressDialog();

    }
}
