package com.vishnus1224.teamworkapidemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.vishnus1224.teamworkapidemo.R;

/**
 * Created by Vishnu on 8/13/2016.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText apiKeyEditText;

    private Button loginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupViews();
    }

    private void setupViews() {

        apiKeyEditText = (EditText) findViewById(R.id.apiTokenEditText);

        loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.loginButton:

                loginButtonClicked();

                break;

        }
    }

    private void loginButtonClicked() {

    }
}
