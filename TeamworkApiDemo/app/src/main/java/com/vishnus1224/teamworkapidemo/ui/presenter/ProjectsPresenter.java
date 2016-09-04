package com.vishnus1224.teamworkapidemo.ui.presenter;

import com.vishnus1224.teamworkapidemo.manager.DataManager;
import com.vishnus1224.teamworkapidemo.mapper.ProjectDtoToSectionMapper;
import com.vishnus1224.teamworkapidemo.model.ProjectDto;
import com.vishnus1224.teamworkapidemo.model.Section;
import com.vishnus1224.teamworkapidemo.ui.view.ProjectsView;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscriber;

/**
 * Created by Vishnu on 9/4/2016.
 */
public class ProjectsPresenter implements BasePresenter<ProjectsView> {

    private ProjectsView projectsView;

    private ProjectDtoToSectionMapper projectDtoToSectionMapper;

    private DataManager projectsDataManager;

    @Inject
    public ProjectsPresenter(ProjectDtoToSectionMapper projectDtoToSectionMapper,
                             @Named("projectDataManager") DataManager projectsDataManager) {
        this.projectDtoToSectionMapper = projectDtoToSectionMapper;
        this.projectsDataManager = projectsDataManager;
    }

    @Override
    public void onViewAttached(ProjectsView projectsView) {

        this.projectsView = projectsView;

    }

    @Override
    public void onViewDetached(ProjectsView projectsView) {

        this.projectsView = null;

        projectsDataManager.unSubscribe();

    }

    public void fetchAllProjects(){

        projectsView.showProgressBar();

        projectsDataManager.getAllItems(new ProjectsSubscriber());

    }


    public void searchProjects(String queryString){

        projectsDataManager.searchItems(queryString, new Subscriber<List<ProjectDto>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<ProjectDto> projectDtoList) {

                projectsView.showProjects(projectDtoToSectionMapper.map(projectDtoList));

            }
        });

    }

    public class ProjectsSubscriber extends Subscriber<List<ProjectDto>> {

        @Override
        public void onCompleted() {

            projectsView.hideProgressBar();

            projectsView.hideRefreshIndicator();

        }

        @Override
        public void onError(Throwable e) {

            projectsView.hideProgressBar();

            projectsView.hideRefreshIndicator();

            projectsView.showError();

        }

        @Override
        public void onNext(List<ProjectDto> projectDtoList) {

            onResponseReceived(projectDtoList);

        }
    }


    private void onResponseReceived(List<ProjectDto> projectDtoList) {

        if(projectDtoList.isEmpty()){

            projectsView.hideNoProjectsView();

            projectsView.showNoProjectsView();


        }else{

            List<Section<ProjectDto>> sectionList = createSectionsFromProjectList(projectDtoList);

            projectsView.hideProgressBar();

            projectsView.hideRefreshIndicator();

            projectsView.hideNoProjectsView();

            projectsView.showProjectsView();

            projectsView.showProjects(sectionList);

        }

    }

    private List<Section<ProjectDto>> createSectionsFromProjectList(List<ProjectDto> projectDtoList){

        return projectDtoToSectionMapper.map(projectDtoList);

    }
}
