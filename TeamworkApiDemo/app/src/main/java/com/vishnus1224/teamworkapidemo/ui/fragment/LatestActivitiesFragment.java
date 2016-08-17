package com.vishnus1224.teamworkapidemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.vishnus1224.teamworkapidemo.R;
import com.vishnus1224.teamworkapidemo.di.component.UserComponent;
import com.vishnus1224.teamworkapidemo.ui.activity.MainActivity;
import com.vishnus1224.teamworkapidemo.ui.presenter.LatestActivitiesPresenter;
import com.vishnus1224.teamworkapidemo.ui.view.LatestActivitiesView;

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

    private ListView latestActivityListView;

    private UserComponent userComponent;

    @Inject
    LatestActivitiesPresenter latestActivitiesPresenter;

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

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        injectDependencies();

        latestActivitiesPresenter.onViewAttached(this);
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



    private void setupViews(View view) {

        checkAgainButton = (Button) view.findViewById(R.id.noActivitiesButtonCheckAgain);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.latestActivitiesSwipeRefresh);

        latestActivityListView = (ListView) view.findViewById(R.id.latestActivitiesListView);

        swipeRefreshLayout.setOnRefreshListener(this);

        checkAgainButton.setOnClickListener(this);

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


    private void injectDependencies() {

        userComponent = ((MainActivity)getActivity()).getUserComponent();

        userComponent.inject(this);

    }

}
