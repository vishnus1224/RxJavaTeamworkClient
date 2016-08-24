package com.vishnus1224.teamworkapidemo.ui.presenter;

import com.vishnus1224.teamworkapidemo.ui.view.LatestActivitiesView;
import com.vishnus1224.teamworkapidemo.usecase.UseCase;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Vishnu on 8/17/2016.
 */
public class LatestActivitiesPresenter implements BasePresenter<LatestActivitiesView> {

    private LatestActivitiesView latestActivitiesView;

    private UseCase useCase;

    @Inject
    public LatestActivitiesPresenter(@Named("activityCloud") UseCase useCase) {

        this.useCase = useCase;

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
