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

        useCase.execute(new LatestActivityCloudSubscriber());

    }

    public class LatestActivityCloudSubscriber extends Subscriber<List<LatestActivityResponse>>{

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

            latestActivitiesView.showError();
        }

        @Override
        public void onNext(List<LatestActivityResponse> latestActivityResponse) {

            List<Section<LatestActivityResponse>> sections = latestActivityToSectionMapper.map(latestActivityResponse);

            latestActivitiesView.showLatestActivityView();

            latestActivitiesView.showLatestActivity(sections);


        }
    }
}
