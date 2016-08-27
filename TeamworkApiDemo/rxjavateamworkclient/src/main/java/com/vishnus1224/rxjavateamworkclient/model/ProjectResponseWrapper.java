package com.vishnus1224.rxjavateamworkclient.model;

import com.bluelinelabs.logansquare.annotation.JsonField;

import java.util.List;

/**
 * Created by Vishnu on 8/27/2016.
 */
public class ProjectResponseWrapper extends BaseResponse{

    @JsonField(name = "projects")
    private List<ProjectResponse> projectResponseList;

    public List<ProjectResponse> getProjectResponseList() {
        return projectResponseList;
    }

    public void setProjectResponseList(List<ProjectResponse> projectResponseList) {
        this.projectResponseList = projectResponseList;
    }
}
