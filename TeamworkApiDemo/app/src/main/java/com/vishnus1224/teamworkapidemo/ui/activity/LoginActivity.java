package com.vishnus1224.teamworkapidemo.ui.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.vishnus1224.teamworkapidemo.R;
import com.vishnus1224.teamworkapidemo.di.component.ActivityComponent;
import com.vishnus1224.teamworkapidemo.di.module.ActivityModule;
import com.vishnus1224.teamworkapidemo.manager.TokenManager;
import com.vishnus1224.teamworkapidemo.ui.presenter.LoginPresenter;
import com.vishnus1224.teamworkapidemo.ui.view.LoginView;

import javax.inject.Inject;


/**
 * Created by Vishnu on 8/13/2016.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginView, DialogInterface.OnCancelListener {

    private EditText apiKeyEditText;

    private Button loginButton;

    private ProgressDialog progressDialog;

    private ActivityComponent activityComponent;

    @Inject
    LoginPresenter loginPresenter;

    @Inject
    TokenManager tokenManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupViews();

        injectDependencies();

        initPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        loginPresenter.onViewDetached(this);

    }


    @Override
    public void showProgressDialog() {

        progressDialog.setMessage(getResources().getString(R.string.label_authenticating));

        progressDialog.show();

    }

    @Override
    public void hideProgressDialog() {

        if(progressDialog.isShowing()) {

            progressDialog.hide();

        }

    }

    @Override
    public void onCancel(DialogInterface dialogInterface) {

        loginPresenter.cancelLogin();

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.loginButton:

                loginButtonClicked();

                break;

        }
    }


    private void setupViews() {

        apiKeyEditText = (EditText) findViewById(R.id.apiTokenEditText);

        loginButton = (Button) findViewById(R.id.loginButton);

        progressDialog = new ProgressDialog(this);

        progressDialog.setOnCancelListener(this);

        loginButton.setOnClickListener(this);
    }

    private void injectDependencies() {

        activityComponent = getApplicationComponent()
                .activityComponent(new ActivityModule(this));

        activityComponent.inject(this);

    }

    private void initPresenter() {

        loginPresenter.onViewAttached(this);

    }

    private void loginButtonClicked() {

        if(isTokenValid(apiKeyEditText.getText().toString())) {

            setToken(apiKeyEditText.getText().toString());

            login();

        }

    }

    private void setToken(String apiToken) {

        tokenManager.setApiToken(apiToken);

    }

    private void login() {

        loginPresenter.loginUser();

    }


    private boolean isTokenValid(String apiToken){

        return !apiToken.trim().isEmpty();

    }
}
