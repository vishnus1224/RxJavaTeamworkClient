package com.vishnus1224.teamworkapidemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.vishnus1224.teamworkapidemo.R;

/**
 * Created by Vishnu on 8/14/2016.
 */
public class LatestActivitiesFragment extends BaseFragment implements MenuItemCompat.OnActionExpandListener, SearchView.OnQueryTextListener {

    private SearchView searchView;

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

        return view;

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

}
