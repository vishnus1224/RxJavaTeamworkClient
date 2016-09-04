package com.vishnus1224.teamworkapidemo.ui.view;

import com.vishnus1224.teamworkapidemo.model.ProjectDto;
import com.vishnus1224.teamworkapidemo.model.Section;

import java.util.List;

/**
 * Created by Vishnu on 9/4/2016.
 */
public interface ProjectsView extends BaseView {

    void showProjects(List<Section<ProjectDto>> projectDtoSectionList);

    void showError();

    void showProjectsView();

    void hideProjectsView();

    void showNoProjectsView();

    void hideNoProjectsView();

    void showProgressBar();

    void hideProgressBar();

    void hideRefreshIndicator();
}
