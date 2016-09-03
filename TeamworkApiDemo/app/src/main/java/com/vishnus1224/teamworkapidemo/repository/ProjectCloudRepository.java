package com.vishnus1224.teamworkapidemo.repository;

import com.vishnus1224.rxjavateamworkclient.model.ProjectResponse;
import com.vishnus1224.teamworkapidemo.datastore.DataStore;
import com.vishnus1224.teamworkapidemo.mapper.ProjectResponseToDtoMapper;
import com.vishnus1224.teamworkapidemo.model.ProjectDto;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Vishnu on 9/3/2016.
 */
public class ProjectCloudRepository implements BaseRepository<ProjectDto> {

    private DataStore projectCloudDataStore;

    private ProjectResponseToDtoMapper projectResponseToDtoMapper;

    @Inject
    public ProjectCloudRepository(@Named("projectCloudDataStore") DataStore projectCloudDataStore,
                                  ProjectResponseToDtoMapper projectResponseToDtoMapper) {

        this.projectCloudDataStore = projectCloudDataStore;

        this.projectResponseToDtoMapper = projectResponseToDtoMapper;
    }

    @Override
    public void add(ProjectDto projectDto) {

    }

    @Override
    public void addAll(List<ProjectDto> projectDtoList) {

    }

    @Override
    public ProjectDto removeItem() {
        return null;
    }

    @Override
    public Observable<ProjectDto> getItem() {
        return null;
    }

    @Override
    public Observable<List<ProjectDto>> getAllItems() {

        return projectCloudDataStore.getAllItems()
                .flatMap(new Func1<List<ProjectResponse>, Observable<List<ProjectDto>>>() {
                    @Override
                    public Observable<List<ProjectDto>> call(List<ProjectResponse> projectResponses) {

                        List<ProjectDto> projectDtoList = new ArrayList<>(projectResponses.size());

                        for(ProjectResponse projectResponse : projectResponses){

                            projectDtoList.add(projectResponseToDtoMapper.map(projectResponse));

                        }

                        return Observable.just(projectDtoList);
                    }

                });

    }

    @Override
    public Observable<List<ProjectDto>> searchItems(String searchString) {
        return null;
    }
}
