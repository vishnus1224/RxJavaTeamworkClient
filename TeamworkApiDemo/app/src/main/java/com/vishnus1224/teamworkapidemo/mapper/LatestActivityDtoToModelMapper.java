package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;
import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;

import javax.inject.Inject;

/**
 * Mapper to convert dto to realm model for saving to realm.
 * Created by vishnu on 01/09/16.
 */
public class LatestActivityDtoToModelMapper implements Mapper<LatestActivityDto, LatestActivityModel> {

    @Inject
    public LatestActivityDtoToModelMapper() {
        
    }

    @Override
    public LatestActivityModel map(LatestActivityDto latestActivityDto) {

        LatestActivityModel latestActivityModel = new LatestActivityModel();

        latestActivityModel.projectId = latestActivityDto.projectId;

        latestActivityModel.itemId = latestActivityDto.itemId;

        latestActivityModel.fromUserAvatarUrl = latestActivityDto.fromUserAvatarUrl;

        latestActivityModel.description = latestActivityDto.description;

        latestActivityModel.forUsername = latestActivityDto.forUsername;

        latestActivityModel.publicInfo = latestActivityDto.publicInfo;

        latestActivityModel.forUserId = latestActivityDto.forUserId;

        latestActivityModel.itemLink = latestActivityDto.itemLink;

        latestActivityModel.dateTime = latestActivityDto.dateTime;

        latestActivityModel.activityType = latestActivityDto.activityType;

        latestActivityModel.companyId = latestActivityDto.companyId;

        latestActivityModel.projectName = latestActivityDto.projectName;

        latestActivityModel.latestActivityType = latestActivityDto.latestActivityType;

        latestActivityModel.link = latestActivityDto.link;

        latestActivityModel.extraDescription = latestActivityDto.extraDescription;

        latestActivityModel.isPrivate = latestActivityDto.isPrivate;

        latestActivityModel.companyName = latestActivityDto.companyName;

        latestActivityModel.id = latestActivityDto.id;

        latestActivityModel.dueDate = latestActivityDto.dueDate;

        latestActivityModel.lockDownId = latestActivityDto.lockDownId;

        latestActivityModel.fromUsername = latestActivityDto.fromUsername;

        latestActivityModel.type = latestActivityDto.type;

        latestActivityModel.forUserAvatarUrl = latestActivityDto.forUserAvatarUrl;

        latestActivityModel.userId = latestActivityDto.userId;

        return latestActivityModel;
    }
}
