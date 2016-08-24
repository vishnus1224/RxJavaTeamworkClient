package com.vishnus1224.teamworkapidemo.ui.presenter;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;
import com.vishnus1224.teamworkapidemo.ui.view.LatestActivitiesView;
import com.vishnus1224.teamworkapidemo.usecase.UseCase;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscriber;

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

    public void fetchLatestActivityFromCloud(){

        useCase.execute(new LatestActivityCloudSubscriber());

    }

    public static class LatestActivityCloudSubscriber extends Subscriber<List<LatestActivityResponse>>{

        @Override
        public void onCompleted() {

            String s = "fdsds";
        }

        @Override
        public void onError(Throwable e) {

            String s = "fdsds";
        }

        @Override
        public void onNext(List<LatestActivityResponse> latestActivityResponse) {

            String s = "fdsds";

        }
    }
}
