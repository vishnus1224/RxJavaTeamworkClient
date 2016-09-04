package com.vishnus1224.teamworkapidemo.ui.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.vishnus1224.teamworkapidemo.model.ProjectDto;
import com.vishnus1224.teamworkapidemo.ui.presenter.ProjectsPresenter;
import com.vishnus1224.teamworkapidemo.ui.view.ProjectsView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Vishnu on 9/4/2016.
 */
public class ProjectFragment extends BaseFragment implements ProjectsView, View.OnClickListener, SearchView.OnQueryTextListener, MenuItemCompat.OnActionExpandListener {

    private RecyclerView recyclerView;

    private Button createProjectButton;

    private LinearLayout noProjectsView;

    private ProgressDialog progressDialog;

    private SearchView searchView;

    private SwipeRefreshLayout swipeRefreshLayout;

    @Inject
    ProjectsPresenter projectsPresenter;

    private UserComponent userComponent;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        obtainUserComponent(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_projects, container, false);

        setupViews(view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        injectDependencies();

        projectsPresenter.onViewAttached(this);

        projectsPresenter.fetchAllProjects();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        projectsPresenter.onViewDetached(this);
    }

    @Override
    public void showProjects(List<ProjectDto> projectDtoList) {

    }

    @Override
    public void showError() {

        Toast.makeText(getActivity(), "An error occurred", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showProjectsView() {

        recyclerView.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProjectsView() {

        recyclerView.setVisibility(View.GONE);

    }

    @Override
    public void showNoProjectsView() {

        noProjectsView.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideNoProjectsView() {

        noProjectsView.setVisibility(View.GONE);

    }

    @Override
    public void showProgressBar() {

        progressDialog.setMessage("Fetching project info");

        progressDialog.show();

    }

    @Override
    public void hideProgressBar() {

        progressDialog.hide();

    }

    @Override
    public void hideRefreshIndicator() {

        if(swipeRefreshLayout.isRefreshing()){

            swipeRefreshLayout.setRefreshing(false);

        }
        
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.noProjectsButtonCreateProject:

                createProjectButtonClicked();

                break;

        }

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.projects_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.menuProjectSearch);

        searchView = (SearchView) menuItem.getActionView();

        searchView.setQueryHint("Search");

        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(menuItem, this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menuProjectAdd:

                addNewProjectClicked();

                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {

        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        projectsPresenter.searchProjects(s);

        return true;
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {

        searchView.setIconified(false);

        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {

        searchView.setQuery("", false);

        projectsPresenter.searchProjects("");

        hideSoftKeyboard(searchView);

        return true;
    }

    private void createProjectButtonClicked() {

        Toast.makeText(getActivity(), "Show new project screen", Toast.LENGTH_SHORT).show();

    }


    private void addNewProjectClicked() {

        Toast.makeText(getActivity(), "Show new project screen", Toast.LENGTH_SHORT).show();

    }



    private void obtainUserComponent(Activity activity) {

        UserComponentDelegate userComponentDelegate;

        try {

            userComponentDelegate = (UserComponentDelegate) activity;

        }catch (ClassCastException e){

            throw new RuntimeException(activity.toString() + " must implement UserComponentDelegate");

        }

        userComponent = userComponentDelegate.provideUserComponent();

    }


    private void injectDependencies() {

        userComponent.fragmentComponent(new FragmentModule(this)).inject(this);

    }

    private void setupViews(View view) {

        recyclerView = (RecyclerView) view.findViewById(R.id.projectsRecyclerView);

        createProjectButton = (Button) view.findViewById(R.id.noProjectsButtonCreateProject);

        noProjectsView = (LinearLayout) view.findViewById(R.id.layoutNoProjects);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.projectsSwipeRefresh);

        progressDialog = new ProgressDialog(getActivity());

        createProjectButton.setOnClickListener(this);

    }

}
