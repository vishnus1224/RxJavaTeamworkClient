package com.vishnus1224.teamworkapidemo.ui.presenter;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;
import com.vishnus1224.teamworkapidemo.mapper.LatestActivityToSectionMapper;
import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;
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

    public class LatestActivityCloudSubscriber extends Subscriber<List<LatestActivityModel>>{

        @Override
        public void onCompleted() {

            latestActivitiesView.hideProgressBar();

            latestActivitiesView.hideRefreshIndicator();

        }

        @Override
        public void onError(Throwable e) {

            latestActivitiesView.hideProgressBar();

            latestActivitiesView.hideRefreshIndicator();

            latestActivitiesView.showError();
        }

        @Override
        public void onNext(List<LatestActivityModel> latestActivityModel) {

            onResponseReceived(latestActivityModel);

        }
    }

    private void onResponseReceived(List<LatestActivityModel> latestActivityModel) {

        //if the response does not contain any items, then show the no activity view.
        if(latestActivityModel.isEmpty()) {

            //hide latest activity view if it was shown previously.
            latestActivitiesView.hideLatestActivityView();

            latestActivitiesView.showNoActivityView();

        }else{

            //create a list of sections for the recycler view to display.
            List<Section<LatestActivityModel>> sections = latestActivityToSectionMapper.map(latestActivityModel);

            //hide the no activity view if it was shown previously.
            latestActivitiesView.hideNoActivityView();

            //show the recycler view.
            latestActivitiesView.showLatestActivityView();

            //show the items in a list.
            latestActivitiesView.showLatestActivity(sections);


        }

    }
}
