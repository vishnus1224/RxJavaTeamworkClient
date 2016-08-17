package com.vishnus1224.teamworkapidemo.ui.presenter;

import com.vishnus1224.teamworkapidemo.ui.view.LatestActivitiesView;

import javax.inject.Inject;

/**
 * Created by Vishnu on 8/17/2016.
 */
public class LatestActivitiesPresenter implements BasePresenter<LatestActivitiesView> {

    private LatestActivitiesView latestActivitiesView;

    @Inject
    public LatestActivitiesPresenter() {
    }

    @Override
    public void onViewAttached(LatestActivitiesView latestActivitiesView) {

        this.latestActivitiesView = latestActivitiesView;

    }

    @Override
    public void onViewDetached(LatestActivitiesView latestActivitiesView) {

        this.latestActivitiesView = null;

    }
}
