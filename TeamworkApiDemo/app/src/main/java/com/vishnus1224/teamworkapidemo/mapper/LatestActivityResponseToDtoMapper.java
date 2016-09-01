package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;
import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;
import com.vishnus1224.teamworkapidemo.util.DateTimeHelper;

import java.text.ParseException;

import javax.inject.Inject;

/**
 * Maps the latest activity response to latest activity dto.
 * Created by Vishnu on 8/28/2016.
 */
public class LatestActivityResponseToDtoMapper implements Mapper<LatestActivityResponse, LatestActivityDto> {

    private DateTimeHelper dateTimeHelper;

    @Inject
    public LatestActivityResponseToDtoMapper(DateTimeHelper dateTimeHelper){

        this.dateTimeHelper = dateTimeHelper;

    }

    @Override
    public LatestActivityDto map(LatestActivityResponse latestActivityResponse) {

        LatestActivityDto latestActivityDto = new LatestActivityDto();

        latestActivityDto.projectId = latestActivityResponse.getProjectId();

        latestActivityDto.itemId = latestActivityResponse.getItemId();

        latestActivityDto.fromUserAvatarUrl = latestActivityResponse.getFromUserAvatarUrl();

        latestActivityDto.description = latestActivityResponse.getDescription();

        latestActivityDto.forUsername = latestActivityResponse.getForUsername();

        latestActivityDto.publicInfo = latestActivityResponse.getPublicInfo();

        latestActivityDto.forUserId = latestActivityResponse.getForUserId();

        latestActivityDto.itemLink = latestActivityResponse.getItemLink();

        try {
            latestActivityDto.dateTime = dateTimeHelper.latestActivityDateTimeToDate(latestActivityResponse.getDateTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        latestActivityDto.activityType = latestActivityResponse.getActivityType();

        latestActivityDto.companyId = latestActivityResponse.getCompanyId();

        latestActivityDto.projectName = latestActivityResponse.getProjectName();

        latestActivityDto.latestActivityType = latestActivityResponse.getLatestActivityType();

        latestActivityDto.link = latestActivityResponse.getLink();

        latestActivityDto.extraDescription = latestActivityResponse.getExtraDescription();

        latestActivityDto.isPrivate = latestActivityResponse.getIsPrivate();

        latestActivityDto.companyName = latestActivityResponse.getCompanyName();

        latestActivityDto.id = latestActivityResponse.getId();

        try {
            latestActivityDto.dueDate = dateTimeHelper.latestActivityDueDateToDate(latestActivityResponse.getDueDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        latestActivityDto.lockDownId = latestActivityResponse.getLockDownId();

        latestActivityDto.fromUsername = latestActivityResponse.getFromUsername();

        latestActivityDto.type = latestActivityResponse.getType();

        latestActivityDto.forUserAvatarUrl = latestActivityResponse.getForUserAvatarUrl();

        latestActivityDto.userId = latestActivityResponse.getUserId();

        return latestActivityDto;
    }
}
