package com.vishnus1224.teamworkapidemo.ui.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.vishnus1224.rxjavateamworkclient.config.TeamworkApiConfig;
import com.vishnus1224.teamworkapidemo.R;
import com.vishnus1224.teamworkapidemo.di.component.UserComponent;
import com.vishnus1224.teamworkapidemo.di.module.UserModule;
import com.vishnus1224.teamworkapidemo.model.UserConfig;
import com.vishnus1224.teamworkapidemo.util.Constants;

public class MainActivity extends BaseActivity {

    private FrameLayout contentFrameLayout;

    private ListView drawerItemsListView;

    private UserComponent userComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle ex = getIntent().getExtras();

        //get the config that is passed in
        UserConfig userConfig = (UserConfig) ex.get(Constants.INTENT_KEY_USER_CONFIG);

        //inject the teamwork api config into the module.
        injectDependencies(userConfig);

        setContentView(R.layout.activity_main);

        setupViews();

        setDrawerListAdapter();

        showActivitiesFragment();

    }

    private void injectDependencies(UserConfig userConfig) {

        userComponent = getApplicationComponent().
                userComponent(new UserModule(new TeamworkApiConfig(userConfig.getApiToken(),
                        userConfig.getUrl())));

        userComponent.inject(this);

    }

    private void setupViews() {

        contentFrameLayout = (FrameLayout) findViewById(R.id.drawerContentFrame);

        drawerItemsListView = (ListView) findViewById(R.id.drawerItemListView);

    }

    private void setDrawerListAdapter() {

        String[] items = getResources().getStringArray(R.array.drawer_items);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, items);

        drawerItemsListView.setAdapter(arrayAdapter);
    }


    private void showActivitiesFragment() {



    }


}
