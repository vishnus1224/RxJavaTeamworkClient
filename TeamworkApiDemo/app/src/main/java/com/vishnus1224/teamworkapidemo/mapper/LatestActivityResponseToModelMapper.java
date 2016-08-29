package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;
import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;
import com.vishnus1224.teamworkapidemo.util.DateTimeHelper;

import java.text.ParseException;

/**
 * Maps the latest activity response to latest activity realm model.
 * Created by Vishnu on 8/28/2016.
 */
public class LatestActivityResponseToModelMapper implements Mapper<LatestActivityResponse, LatestActivityModel> {

    private DateTimeHelper dateTimeHelper;

    public LatestActivityResponseToModelMapper(DateTimeHelper dateTimeHelper){

        this.dateTimeHelper = dateTimeHelper;

    }

    @Override
    public LatestActivityModel map(LatestActivityResponse latestActivityResponse) {

        LatestActivityModel latestActivityModel = new LatestActivityModel();

        latestActivityModel.projectId = latestActivityResponse.getProjectId();

        latestActivityModel.itemId = latestActivityResponse.getItemId();

        latestActivityModel.fromUserAvatarUrl = latestActivityResponse.getFromUserAvatarUrl();

        latestActivityModel.description = latestActivityResponse.getDescription();

        latestActivityModel.forUsername = latestActivityResponse.getForUsername();

        latestActivityModel.publicInfo = latestActivityResponse.getPublicInfo();

        latestActivityModel.forUserId = latestActivityResponse.getForUserId();

        latestActivityModel.itemLink = latestActivityResponse.getItemLink();

        try {
            latestActivityModel.dateTime = dateTimeHelper.latestActivityDateTimeToDate(latestActivityResponse.getDateTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        latestActivityModel.activityType = latestActivityResponse.getActivityType();

        latestActivityModel.companyId = latestActivityResponse.getCompanyId();

        latestActivityModel.projectName = latestActivityResponse.getProjectName();

        latestActivityModel.latestActivityType = latestActivityResponse.getLatestActivityType();

        latestActivityModel.link = latestActivityResponse.getLink();

        latestActivityModel.extraDescription = latestActivityResponse.getExtraDescription();

        latestActivityModel.isPrivate = latestActivityResponse.getIsPrivate();

        latestActivityModel.companyName = latestActivityResponse.getCompanyName();

        latestActivityModel.id = latestActivityResponse.getId();

        try {
            latestActivityModel.dueDate = dateTimeHelper.latestActivityDueDateToDate(latestActivityResponse.getDueDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        latestActivityModel.lockDownId = latestActivityResponse.getLockDownId();

        latestActivityModel.fromUsername = latestActivityResponse.getFromUsername();

        latestActivityModel.type = latestActivityResponse.getType();

        latestActivityModel.forUserAvatarUrl = latestActivityResponse.getForUserAvatarUrl();

        latestActivityModel.userId = latestActivityResponse.getUserId();

        return latestActivityModel;
    }
}
