package com.vishnus1224.teamworkapidemo.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.vishnus1224.teamworkapidemo.R;
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

    protected void replaceFragment(int layoutId, Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(layoutId, fragment);

        transaction.commit();

        fragmentManager.executePendingTransactions();

    }
}
