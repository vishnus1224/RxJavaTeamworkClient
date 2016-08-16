package com.vishnus1224.teamworkapidemo.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.vishnus1224.rxjavateamworkclient.config.TeamworkApiConfig;
import com.vishnus1224.teamworkapidemo.R;
import com.vishnus1224.teamworkapidemo.di.component.UserComponent;
import com.vishnus1224.teamworkapidemo.di.module.UserModule;
import com.vishnus1224.teamworkapidemo.model.UserConfig;
import com.vishnus1224.teamworkapidemo.ui.fragment.LatestActivitiesFragment;
import com.vishnus1224.teamworkapidemo.ui.presenter.MainPresenter;
import com.vishnus1224.teamworkapidemo.ui.view.MainView;
import com.vishnus1224.teamworkapidemo.util.Constants;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainView {

    private FrameLayout contentFrameLayout;

    private ListView drawerItemsListView;

    private DrawerLayout drawerLayout;

    private UserComponent userComponent;

    @Inject
    MainPresenter mainPresenter;

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

        initPresenter();

        initActionBar();

        setDrawerListAdapter();

        setDrawerItemClickListener();

        showLatestActivityScreen();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mainPresenter.onViewDetached(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:

                toggleDrawerState();
                
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showLatestActivityScreen() {

        LatestActivitiesFragment latestActivitiesFragment = new LatestActivitiesFragment();

        replaceFragment(R.id.drawerContentFrame, latestActivitiesFragment);

    }

    @Override
    public void showProjectsScreen() {

    }

    @Override
    public void showTaskScreen() {

    }

    @Override
    public void openDrawer(){

        drawerLayout.openDrawer(drawerItemsListView);

    }

    @Override
    public void closeDrawer() {

        if(drawerLayout.isDrawerOpen(drawerItemsListView)){

            drawerLayout.closeDrawer(drawerItemsListView);

        }

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

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

    }



    private void initPresenter() {

        mainPresenter.onViewAttached(this);

    }


    private void initActionBar() {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setHomeButtonEnabled(true);

        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.ic_media_pause);

    }


    private void setDrawerListAdapter() {

        String[] items = getResources().getStringArray(R.array.drawer_items);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, items);

        drawerItemsListView.setAdapter(arrayAdapter);
    }


    private void setDrawerItemClickListener() {

        drawerItemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                mainPresenter.drawerItemClicked(i);

            }
        });

    }


    private void toggleDrawerState() {

        if(drawerLayout.isDrawerOpen(drawerItemsListView)){

            closeDrawer();

        }else{

            openDrawer();

        }

    }

}
