package com.vishnus1224.teamworkapidemo.ui.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vishnus1224.teamworkapidemo.R;
import com.vishnus1224.teamworkapidemo.di.component.ActivityComponent;
import com.vishnus1224.teamworkapidemo.di.module.ActivityModule;
import com.vishnus1224.teamworkapidemo.ui.presenter.LoginPresenter;
import com.vishnus1224.teamworkapidemo.ui.view.LoginView;
import com.vishnus1224.teamworkapidemo.util.Constants;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectDependencies();

        if(alreadyLoggedIn()){

            goToMainScreen();

        }

        setContentView(R.layout.activity_login);

        setupViews();

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
    public void showError(String message) {

        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void goToMainScreen() {

        Intent mainActivityIntent = new Intent(this, MainActivity.class);

        mainActivityIntent.putExtra(Constants.INTENT_KEY_USER_CONFIG, loginPresenter.obtainUserConfig());

        startActivity(mainActivityIntent);

        finish();

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

            login(apiKeyEditText.getText().toString());

        }

    }


    private void login(String apiToken) {

        loginPresenter.loginUser(apiToken);

    }


    private boolean isTokenValid(String apiToken){

        return !apiToken.trim().isEmpty();

    }


    private boolean alreadyLoggedIn() {

        return loginPresenter.obtainUserConfig().getApiToken() != null;

    }
}
