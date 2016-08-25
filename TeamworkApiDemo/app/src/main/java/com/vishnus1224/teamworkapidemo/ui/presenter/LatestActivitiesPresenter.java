package com.vishnus1224.teamworkapidemo.ui.presenter;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;
import com.vishnus1224.teamworkapidemo.mapper.LatestActivityToSectionMapper;
import com.vishnus1224.teamworkapidemo.model.Section;
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

    private LatestActivityToSectionMapper latestActivityToSectionMapper;

    @Inject
    public LatestActivitiesPresenter(@Named("activityCloud") UseCase useCase, LatestActivityToSectionMapper latestActivityToSectionMapper) {

        this.useCase = useCase;

        this.latestActivityToSectionMapper = latestActivityToSectionMapper;

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

        latestActivitiesView.showProgressBar();

        useCase.execute(new LatestActivityCloudSubscriber());

    }

    public class LatestActivityCloudSubscriber extends Subscriber<List<LatestActivityResponse>>{

        @Override
        public void onCompleted() {

            latestActivitiesView.hideProgressBar();

        }

        @Override
        public void onError(Throwable e) {

            latestActivitiesView.hideProgressBar();

            latestActivitiesView.showError();
        }

        @Override
        public void onNext(List<LatestActivityResponse> latestActivityResponse) {

            onResponseReceived(latestActivityResponse);


        }
    }

    private void onResponseReceived(List<LatestActivityResponse> latestActivityResponse) {

        //create a list of sections for the recycler view to display.
        List<Section<LatestActivityResponse>> sections = latestActivityToSectionMapper.map(latestActivityResponse);

        //show the recycler view.
        latestActivitiesView.showLatestActivityView();

        //show the items in a list.
        latestActivitiesView.showLatestActivity(sections);

    }
}
