package com.vishnus1224.teamworkapidemo.ui.activity;

import android.support.v7.app.AppCompatActivity;

import com.vishnus1224.teamworkapidemo.TeamworkApiDemo;
import com.vishnus1224.teamworkapidemo.di.component.ApplicationComponent;

/**
 * Created by Vishnu on 8/13/2016.
 */
public class BaseActivity extends AppCompatActivity {

    protected ApplicationComponent getApplicationComponent(){

        return getTeamApiDemo().getApplicationComponent();

    }

    private TeamworkApiDemo getTeamApiDemo() {

        return (TeamworkApiDemo) getApplication();

    }
}
