package com.vishnus1224.teamworkapidemo.ui.view;

import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;
import com.vishnus1224.teamworkapidemo.model.Section;

import java.util.List;

/**
 * Created by Vishnu on 8/17/2016.
 */
public interface LatestActivitiesView extends BaseView {

    void showLatestActivity(List<Section<LatestActivityDto>> sections);

    void showNoActivityView();

    void hideNoActivityView();

    void showProgressBar();

    void hideProgressBar();

    void showError();

    void showLatestActivityView();

    void hideLatestActivityView();

    void hideRefreshIndicator();

}
