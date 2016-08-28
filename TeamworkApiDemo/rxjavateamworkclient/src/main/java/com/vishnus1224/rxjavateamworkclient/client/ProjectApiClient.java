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
        , UpdatedAfterTime<ProjectApiClient>, OrderBy<ProjectApiClient>, CreatedAfterDate<ProjectApiClient>
        , CreatedAfterTime<ProjectApiClient>, Paginated<ProjectApiClient>{

    //Query param constants.
    public static final String PROJECT_STATUS_ALL = "ALL";
    public static final String PROJECT_STATUS_ACTIVE = "ACTIVE";
    public static final String PROJECT_STATUS_ARCHIVED = "ARCHIVED";
    public static final String PROJECT_STATUS_CURRENT = "CURRENT";
    public static final String PROJECT_STATUS_LATE = "LATE";
    public static final String PROJECT_STATUS_COMPLETED = "COMPLETED";

    public static final String ORDER_BY_NAME = "name";
    public static final String ORDER_BY_COMPANY_NAME = "companyName";
    public static final String ORDER_BY_LAST_ACTIVITY_DATE = "lastActivityDate";

    //Query param keys.
    private static final String KEY_PROJECT_STATUS = "status";
    private static final String KEY_UPDATE_AFTER_DATE = "updatedAfterDate";
    private static final String KEY_UPDATE_AFTER_TIME = "updatedAfterTime";
    private static final String KEY_ORDER_BY = "orderBy";
    private static final String KEY_CREATED_AFTER_DATE = "createdAfterDate";
    private static final String KEY_CREATED_AFTER_TIME = "createdAfterTime";
    private static final String KEY_INCLUDE_PEOPLE = "includePeople";
    private static final String KEY_PAGE = "page";

    private String projectStatus;

    private String updatedAfterDate;

    private String updateAfterTime;

    private String orderBy;

    private String createdAfterDate;

    private String createdAfterTime;

    private boolean includePeople;

    private int page;

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

    @Override
    public ProjectApiClient updatedAfterDate(String date) throws ParseException {

        try {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMDD");

            simpleDateFormat.parse(date);

        } catch (ParseException e) {

            e.printStackTrace();

            throw new ParseException("Date should be in YYYYMMDD format", 0);

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

    @Override
    public ProjectApiClient orderBy(String orderBy) {

        this.orderBy = orderBy;

        return this;
    }


    @Override
    public ProjectApiClient createdAfterDate(String date) throws ParseException {

        try {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMDD");

            simpleDateFormat.parse(date);

        } catch (ParseException e) {

            e.printStackTrace();

            throw new ParseException("Date should be in YYYYMMDDH format", 0);

        }

        this.createdAfterDate = date;

        return this;
    }

    @Override
    public ProjectApiClient createdAfterTime(String timeString) throws ParseException {

        try {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:MM");

            simpleDateFormat.parse(timeString);

        } catch (ParseException e) {

            e.printStackTrace();

            throw new ParseException("time should be in HH:MM format", 0);

        }

        this.createdAfterTime = timeString;

        return this;
    }

    private ProjectApiClient includePeople(boolean includePeople){

        this.includePeople = includePeople;

        return this;
    }

    @Override
    public ProjectApiClient page(int pageNumber) {

        this.page = pageNumber;

        return this;
    }

    /**
     * Creates a map from the fields that are set.
     * @return Map containing query params.
     */
    private Map<String, Object> buildQueryMap() {

        Map<String, Object> queryParamMap = new HashMap<>();

        if(projectStatus != null){

            queryParamMap.put(KEY_PROJECT_STATUS, projectStatus);

        }

        if(updatedAfterDate != null){

            queryParamMap.put(KEY_UPDATE_AFTER_DATE, updatedAfterDate);

        }

        if(updateAfterTime != null){

            queryParamMap.put(KEY_UPDATE_AFTER_TIME, updateAfterTime);

        }

        if(orderBy != null){

            queryParamMap.put(KEY_ORDER_BY, orderBy);

        }

        if(createdAfterDate != null){

            queryParamMap.put(KEY_CREATED_AFTER_DATE, createdAfterDate);

        }

        if(createdAfterTime != null){

            queryParamMap.put(KEY_CREATED_AFTER_TIME, createdAfterTime);

        }

        queryParamMap.put(KEY_INCLUDE_PEOPLE, includePeople);

        queryParamMap.put(KEY_PAGE, page);

        return queryParamMap;
    }

}
