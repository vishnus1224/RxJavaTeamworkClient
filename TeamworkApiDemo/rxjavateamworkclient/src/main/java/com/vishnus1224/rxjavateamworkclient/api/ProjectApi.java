package com.vishnus1224.rxjavateamworkclient.api;

import com.vishnus1224.rxjavateamworkclient.model.ProjectResponseWrapper;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Vishnu on 8/27/2016.
 */
public interface ProjectApi {

    /**
     * Retrieve all projects from the api.
     * @param queryMap Map containing query params.
     * @return Observable containing a list of projects.
     */
    @GET("/projects.json")
    Observable<ProjectResponseWrapper> getAllProjects(@QueryMap Map<String, Object> queryMap);

}
