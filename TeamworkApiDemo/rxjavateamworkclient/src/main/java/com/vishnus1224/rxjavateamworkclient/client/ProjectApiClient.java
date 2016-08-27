package com.vishnus1224.rxjavateamworkclient.client;

import com.vishnus1224.rxjavateamworkclient.api.ProjectApi;
import com.vishnus1224.rxjavateamworkclient.config.TeamworkApiConfig;
import com.vishnus1224.rxjavateamworkclient.model.ProjectResponseWrapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import rx.Observable;

/**
 * Created by Vishnu on 8/27/2016.
 */
public class ProjectApiClient extends TeamworkApiClient implements UpdatedAfterDate<ProjectApiClient>
        , UpdatedAfterTime<ProjectApiClient>{

    //Query param constants.
    public static final String PROJECT_STATUS_ALL = "ALL";
    public static final String PROJECT_STATUS_ACTIVE = "ACTIVE";
    public static final String PROJECT_STATUS_ARCHIVED = "ARCHIVED";
    public static final String PROJECT_STATUS_CURRENT = "CURRENT";
    public static final String PROJECT_STATUS_LATE = "LATE";
    public static final String PROJECT_STATUS_COMPLETED = "COMPLETED";

    //Query param keys.
    private static final String KEY_PROJECT_STATUS = "status";
    private static final String KEY_UPDATE_AFTER_DATE = "updatedAfterDate";
    private static final String KEY_UPDATE_AFTER_TIME = "updatedAfterTime";

    private String projectStatus;

    private String updatedAfterDate;

    private String updateAfterTime;

    protected ProjectApiClient(TeamworkApiConfig teamworkApiConfig) {
        super(teamworkApiConfig);
    }

    public Observable<ProjectResponseWrapper> getAllProjects(){

        return getRetrofit().create(ProjectApi.class).getAllProjects(buildQueryMap());

    }

    /**
     * Set the status to filter out the projects.
     * @param status one of the above defined status constants.
     * @return current instance with the status set.
     */
    public ProjectApiClient status(String status){

        this.projectStatus = status;

        return this;

    }

    /**
     * Creates a map from the fields that are set.
     * @return Map containing query params.
     */
    private Map<String, String> buildQueryMap() {

        Map<String, String> queryParamMap = new HashMap<>();

        if(projectStatus != null){

            queryParamMap.put(KEY_PROJECT_STATUS, projectStatus);

        }

        if(updatedAfterDate != null){

            queryParamMap.put(KEY_UPDATE_AFTER_DATE, updatedAfterDate);

        }

        if(updateAfterTime != null){

            queryParamMap.put(KEY_UPDATE_AFTER_TIME, updateAfterTime);

        }

        return queryParamMap;
    }

    @Override
    public ProjectApiClient updatedAfterDate(String date) throws ParseException {

        try {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMDDHHMMSS");

            simpleDateFormat.parse(date);

        } catch (ParseException e) {

            e.printStackTrace();

            throw new ParseException("Date should be in YYYYMMDDHHMMSS format", 0);

        }

        this.updatedAfterDate = date;

        return this;
    }

    @Override
    public ProjectApiClient updatedAfterTime(String timeString) throws ParseException {

        try {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:MM");

            simpleDateFormat.parse(timeString);

        } catch (ParseException e) {

            e.printStackTrace();

            throw new ParseException("time should be in HH:MM format", 0);

        }

        this.updateAfterTime = timeString;

        return this;
    }
}
