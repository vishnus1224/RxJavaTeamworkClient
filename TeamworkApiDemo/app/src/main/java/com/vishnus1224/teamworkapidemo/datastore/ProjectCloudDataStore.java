package com.vishnus1224.teamworkapidemo.datastore;

import com.vishnus1224.rxjavateamworkclient.client.ProjectApiClient;
import com.vishnus1224.rxjavateamworkclient.model.ProjectResponse;
import com.vishnus1224.rxjavateamworkclient.model.ProjectResponseWrapper;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Vishnu on 9/2/2016.
 */
public class ProjectCloudDataStore implements DataStore<ProjectResponse>{

    private ProjectApiClient projectApiClient;

    @Inject
    public ProjectCloudDataStore(ProjectApiClient projectApiClient) {

        this.projectApiClient = projectApiClient;

    }

    @Override
    public Observable<List<ProjectResponse>> getAllItems() {

        return projectApiClient.getAllProjects().
                flatMap(new Func1<ProjectResponseWrapper, Observable<List<ProjectResponse>>>() {
                    @Override
                    public Observable<List<ProjectResponse>> call(ProjectResponseWrapper projectResponseWrapper) {

                        return Observable.just(projectResponseWrapper.getProjectResponseList());

                    }
                });
    }
}
