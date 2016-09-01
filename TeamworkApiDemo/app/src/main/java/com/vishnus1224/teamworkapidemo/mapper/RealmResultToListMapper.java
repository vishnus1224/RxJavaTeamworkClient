package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;
import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.RealmResults;

/**
 * Created by Vishnu on 8/29/2016.
 */
public class RealmResultToListMapper implements Mapper<RealmResults<LatestActivityModel>, List<LatestActivityDto>> {

    @Inject
    public RealmResultToListMapper() {

    }


    @Override
    public List<LatestActivityDto> map(RealmResults<LatestActivityModel> latestActivityModels) {

        List<LatestActivityDto> list = new ArrayList<>(latestActivityModels.size());

        for(LatestActivityModel latestActivityModel : latestActivityModels){

            LatestActivityDto latestActivityDto = new LatestActivityDto();

            latestActivityDto.projectId = latestActivityModel.projectId;

            latestActivityDto.itemId = latestActivityModel.itemId;

            latestActivityDto.fromUserAvatarUrl = latestActivityModel.fromUserAvatarUrl;

            latestActivityDto.description = latestActivityModel.description;

            latestActivityDto.forUsername = latestActivityModel.forUsername;

            latestActivityDto.publicInfo = latestActivityModel.publicInfo;

            latestActivityDto.forUserId = latestActivityModel.forUserId;

            latestActivityDto.itemLink = latestActivityModel.itemLink;

            latestActivityDto.dateTime = latestActivityModel.dateTime;

            latestActivityDto.activityType = latestActivityModel.activityType;

            latestActivityDto.companyId = latestActivityModel.companyId;

            latestActivityDto.projectName = latestActivityModel.projectName;

            latestActivityDto.latestActivityType = latestActivityModel.latestActivityType;

            latestActivityDto.link = latestActivityModel.link;

            latestActivityDto.extraDescription = latestActivityModel.extraDescription;

            latestActivityDto.isPrivate = latestActivityModel.isPrivate;

            latestActivityDto.companyName = latestActivityModel.companyName;

            latestActivityDto.id = latestActivityModel.id;

            latestActivityDto.dueDate = latestActivityModel.dueDate;

            latestActivityDto.lockDownId = latestActivityModel.lockDownId;

            latestActivityDto.fromUsername = latestActivityModel.fromUsername;

            latestActivityDto.type = latestActivityModel.type;

            latestActivityDto.forUserAvatarUrl = latestActivityModel.forUserAvatarUrl;

            latestActivityDto.userId = latestActivityModel.userId;

            latestActivityDto.formattedDescription = latestActivityModel.formattedDescription;

            list.add(latestActivityDto);

        }

        return list;
    }
}
