package com.vishnus1224.teamworkapidemo.ui.presenter;

import com.vishnus1224.teamworkapidemo.manager.DataManager;
import com.vishnus1224.teamworkapidemo.mapper.LatestActivityToSectionMapper;
import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;
import com.vishnus1224.teamworkapidemo.model.Section;
import com.vishnus1224.teamworkapidemo.ui.view.LatestActivitiesView;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscriber;

/**
 * Created by Vishnu on 8/17/2016.
 */
public class LatestActivitiesPresenter implements BasePresenter<LatestActivitiesView> {

    private LatestActivitiesView latestActivitiesView;

    private LatestActivityToSectionMapper latestActivityToSectionMapper;

    private DataManager latestActivityDataManager;

    @Inject
    public LatestActivitiesPresenter(LatestActivityToSectionMapper latestActivityToSectionMapper,
                                     @Named("activityDataManager") DataManager latestActivityDataManager) {

        this.latestActivityToSectionMapper = latestActivityToSectionMapper;

        this.latestActivityDataManager = latestActivityDataManager;

    }

    @Override
    public void onViewAttached(LatestActivitiesView latestActivitiesView) {

        this.latestActivitiesView = latestActivitiesView;

    }

    @Override
    public void onViewDetached(LatestActivitiesView latestActivitiesView) {

        this.latestActivitiesView = null;

        latestActivityDataManager.unSubscribe();

    }

    public void fetchLatestActivityFromCloud(){

        latestActivitiesView.showProgressBar();

        latestActivityDataManager.getAllItems(new LatestActivityCloudSubscriber());

    }

    public void searchItems(String query){

        latestActivityDataManager.searchItems(query, new Subscriber<List<LatestActivityDto>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<LatestActivityDto> latestActivityDtoList) {

                latestActivitiesView.showLatestActivity(convertToSections(latestActivityDtoList));

            }
        });

    }

    public class LatestActivityCloudSubscriber extends Subscriber<List<LatestActivityDto>>{

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
        public void onNext(List<LatestActivityDto> latestActivityDtoList) {

            onResponseReceived(latestActivityDtoList);

        }
    }

    private void onResponseReceived(List<LatestActivityDto> latestActivityDtoList) {

        //if the response does not contain any items, then show the no activity view.
        if(latestActivityDtoList.isEmpty()) {

            latestActivitiesView.hideProgressBar();

            latestActivitiesView.hideRefreshIndicator();

            //hide latest activity view if it was shown previously.
            latestActivitiesView.hideLatestActivityView();

            latestActivitiesView.showNoActivityView();

        }else{

            //create a list of sections for the recycler view to display.
            List<Section<LatestActivityDto>> sections = convertToSections(latestActivityDtoList);

            latestActivitiesView.hideProgressBar();

            latestActivitiesView.hideRefreshIndicator();

            //hide the no activity view if it was shown previously.
            latestActivitiesView.hideNoActivityView();

            //show the recycler view.
            latestActivitiesView.showLatestActivityView();

            //show the items in a list.
            latestActivitiesView.showLatestActivity(sections);


        }

    }

    private List<Section<LatestActivityDto>> convertToSections(List<LatestActivityDto> latestActivityDtoList) {

        return latestActivityToSectionMapper.map(latestActivityDtoList);

    }
}
