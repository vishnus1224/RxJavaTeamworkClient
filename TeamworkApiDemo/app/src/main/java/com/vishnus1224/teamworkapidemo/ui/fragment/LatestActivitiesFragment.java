package com.vishnus1224.teamworkapidemo.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;
import com.vishnus1224.teamworkapidemo.R;
import com.vishnus1224.teamworkapidemo.delegate.UserComponentDelegate;
import com.vishnus1224.teamworkapidemo.di.component.UserComponent;
import com.vishnus1224.teamworkapidemo.model.Section;
import com.vishnus1224.teamworkapidemo.ui.adapter.LatestActivitiesAdapter;
import com.vishnus1224.teamworkapidemo.ui.presenter.LatestActivitiesPresenter;
import com.vishnus1224.teamworkapidemo.ui.view.LatestActivitiesView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Vishnu on 8/14/2016.
 */
public class LatestActivitiesFragment extends BaseFragment implements MenuItemCompat.OnActionExpandListener,
        SearchView.OnQueryTextListener, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener,
        LatestActivitiesView {

    private SearchView searchView;

    private Button checkAgainButton;

    private SwipeRefreshLayout swipeRefreshLayout;

    private RecyclerView latestActivityRecyclerView;

    private LinearLayout noActivityLayout;

    private UserComponent userComponent;

    private LatestActivitiesAdapter latestActivitiesAdapter;

    @Inject
    LatestActivitiesPresenter latestActivitiesPresenter;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        obtainUserComponent(activity);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //contribute items to the action menu.
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_latest_activities, container, false);

        setupViews(view);

        setupAdapter();

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        injectDependencies();

        latestActivitiesPresenter.onViewAttached(this);

        latestActivitiesPresenter.fetchLatestActivityFromCloud();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        latestActivitiesPresenter.onViewDetached(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.latest_activities_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.latest_activities_search);

        searchView = (SearchView) searchItem.getActionView();

        searchView.setQueryHint("Search");

        //callback when the query text changes.
        searchView.setOnQueryTextListener(this);

        //callback to listen for expanding and collapsing events.
        MenuItemCompat.setOnActionExpandListener(searchItem, this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.latest_activities_search:

                return true;

            case R.id.latest_activities_add:

                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {

        //show the keyboard when the search view is expanded.
        searchView.setIconified(false);

        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {

        hideSoftKeyboard(searchView);

        return true;

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.noActivitiesButtonCheckAgain:


                break;

        }

    }

    @Override
    public void onRefresh() {


    }


    @Override
    public void showLatestActivity(final List<Section<LatestActivityResponse>> sections) {

        latestActivitiesAdapter.updateData(sections);

    }

    @Override
    public void showNoActivityView() {

        noActivityLayout.setVisibility(View.VISIBLE);

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showError() {


    }

    @Override
    public void showLatestActivityView() {

        latestActivityRecyclerView.setVisibility(View.VISIBLE);

    }


    private void obtainUserComponent(Activity activity) {

        UserComponentDelegate userComponentDelegate;

        try {
            userComponentDelegate = (UserComponentDelegate) activity;
        }catch (ClassCastException e){

            throw new ClassCastException("Activity must implement UserComponentDelegate");
        }

        userComponent = userComponentDelegate.provideUserComponent();
    }



    private void setupViews(View view) {

        checkAgainButton = (Button) view.findViewById(R.id.noActivitiesButtonCheckAgain);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.latestActivitiesSwipeRefresh);

        latestActivityRecyclerView = (RecyclerView) view.findViewById(R.id.latestActivitiesRecyclerView);

        noActivityLayout = (LinearLayout) view.findViewById(R.id.layoutNoActivity);

        swipeRefreshLayout.setOnRefreshListener(this);

        checkAgainButton.setOnClickListener(this);

    }


    private void setupAdapter() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        latestActivityRecyclerView.setLayoutManager(layoutManager);

        latestActivitiesAdapter = new LatestActivitiesAdapter();

        latestActivityRecyclerView.setAdapter(latestActivitiesAdapter);

    }



    private void injectDependencies() {


        userComponent.inject(this);


    }
}
