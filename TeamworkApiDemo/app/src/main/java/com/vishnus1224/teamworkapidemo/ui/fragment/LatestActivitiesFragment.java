package com.vishnus1224.teamworkapidemo.ui.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
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
import android.widget.Toast;

import com.vishnus1224.teamworkapidemo.R;
import com.vishnus1224.teamworkapidemo.delegate.UserComponentDelegate;
import com.vishnus1224.teamworkapidemo.di.component.UserComponent;
import com.vishnus1224.teamworkapidemo.di.module.FragmentModule;
import com.vishnus1224.teamworkapidemo.listener.AddNewActivityItemClickListener;
import com.vishnus1224.teamworkapidemo.listener.LatestActivityItemClickListener;
import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;
import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;
import com.vishnus1224.teamworkapidemo.model.Section;
import com.vishnus1224.teamworkapidemo.ui.adapter.LatestActivitiesAdapter;
import com.vishnus1224.teamworkapidemo.ui.fragment.dialog.AddNewActivityDialogFragment;
import com.vishnus1224.teamworkapidemo.ui.presenter.LatestActivitiesPresenter;
import com.vishnus1224.teamworkapidemo.ui.view.LatestActivitiesView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Vishnu on 8/14/2016.
 */
public class LatestActivitiesFragment extends BaseFragment implements MenuItemCompat.OnActionExpandListener,
        SearchView.OnQueryTextListener, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener,
        LatestActivitiesView, LatestActivityItemClickListener {

    private SearchView searchView;

    private Button checkAgainButton;

    private SwipeRefreshLayout swipeRefreshLayout;

    private RecyclerView latestActivityRecyclerView;

    private LinearLayout noActivityLayout;

    private ProgressDialog progressDialog;

    private UserComponent userComponent;

    private LatestActivitiesAdapter latestActivitiesAdapter;

    private AddNewActivityItemClickListener addNewActivityItemClickListener;

    @Inject
    LatestActivitiesPresenter latestActivitiesPresenter;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        obtainUserComponent(activity);

        obtainAddNewActivityItemClickListener(activity);
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

                addNewActivityClicked();

                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    private void addNewActivityClicked() {

        DialogFragment dialog = AddNewActivityDialogFragment.newInstance(addNewActivityItemClickListener);
        dialog.show(getActivity().getSupportFragmentManager(), "addNewActivity");

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        latestActivitiesPresenter.searchItems(s);

        return true;
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {

        //show the keyboard when the search view is expanded.
        searchView.setIconified(false);

        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {

        searchView.setQuery("", false);

        //reset the data when the search view is collapsed.
        latestActivitiesPresenter.searchItems("");

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

        latestActivitiesPresenter.fetchLatestActivityFromCloud();

    }


    @Override
    public void showLatestActivity(final List<Section<LatestActivityDto>> sections) {

        latestActivitiesAdapter.updateData(sections);

    }

    @Override
    public void showNoActivityView() {

        noActivityLayout.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideNoActivityView() {

        noActivityLayout.setVisibility(View.GONE);
    }

    @Override
    public void showProgressBar() {

        progressDialog.setMessage("Loading latest activity");
        progressDialog.show();

    }

    @Override
    public void hideProgressBar() {

        progressDialog.hide();

    }

    @Override
    public void showError() {

        Toast.makeText(getActivity(), "An error occurred.Please try again", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showLatestActivityView() {

        latestActivityRecyclerView.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLatestActivityView() {

        latestActivityRecyclerView.setVisibility(View.GONE);

    }

    @Override
    public void hideRefreshIndicator() {

        if(swipeRefreshLayout.isRefreshing()){

            swipeRefreshLayout.setRefreshing(false);

        }
    }


    @Override
    public void onProjectClicked(LatestActivityDto latestActivityDto) {

        Toast.makeText(getActivity(), "Show project home", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onTaskClicked(LatestActivityDto latestActivityDto) {

        Toast.makeText(getActivity(), "Show task details", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAvatarClicked(LatestActivityDto latestActivityDto) {

        Toast.makeText(getActivity(), "Show contact details", Toast.LENGTH_SHORT).show();

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



    private void obtainAddNewActivityItemClickListener(Activity activity) {

        try {

            addNewActivityItemClickListener = (AddNewActivityItemClickListener) activity;

        }catch (ClassCastException e){

            throw new ClassCastException("Activity must implement AddNewActivityItemClickListener");
        }
    }



    private void setupViews(View view) {

        checkAgainButton = (Button) view.findViewById(R.id.noActivitiesButtonCheckAgain);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.latestActivitiesSwipeRefresh);

        latestActivityRecyclerView = (RecyclerView) view.findViewById(R.id.latestActivitiesRecyclerView);

        noActivityLayout = (LinearLayout) view.findViewById(R.id.layoutNoActivity);

        progressDialog = new ProgressDialog(getActivity());

        swipeRefreshLayout.setOnRefreshListener(this);

        checkAgainButton.setOnClickListener(this);

    }


    private void setupAdapter() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        latestActivityRecyclerView.setLayoutManager(layoutManager);

        latestActivitiesAdapter = new LatestActivitiesAdapter(getActivity(), this);

        latestActivityRecyclerView.setAdapter(latestActivitiesAdapter);

    }



    private void injectDependencies() {


        userComponent.fragmentComponent(new FragmentModule(this))
                .inject(this);


    }

}
