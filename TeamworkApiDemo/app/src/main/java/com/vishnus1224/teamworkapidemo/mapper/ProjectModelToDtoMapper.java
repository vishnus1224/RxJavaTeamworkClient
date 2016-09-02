package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.teamworkapidemo.model.CategoryDto;
import com.vishnus1224.teamworkapidemo.model.ProjectDto;
import com.vishnus1224.teamworkapidemo.model.ProjectRealmModel;

import javax.inject.Inject;

/**
 * Created by Vishnu on 9/2/2016.
 */
public class ProjectModelToDtoMapper implements Mapper<ProjectRealmModel, ProjectDto> {

    private TagModelToDtoListMapper tagModelToDtoListMapper;

    private PeopleModelToDtoListMapper peopleModelToDtoListMapper;

    @Inject
    public ProjectModelToDtoMapper(TagModelToDtoListMapper tagModelToDtoListMapper, PeopleModelToDtoListMapper peopleModelToDtoListMapper) {
        this.tagModelToDtoListMapper = tagModelToDtoListMapper;
        this.peopleModelToDtoListMapper = peopleModelToDtoListMapper;
    }

    @Override
    public ProjectDto map(ProjectRealmModel projectRealmModel) {

        ProjectDto projectDto = new ProjectDto();

        projectDto.replyByEmailEnabled = projectRealmModel.replyByEmailEnabled;

        projectDto.starred = projectRealmModel.starred;

        projectDto.showAnnouncement = projectRealmModel.showAnnouncement;

        projectDto.harvestTimersEnabled = projectRealmModel.harvestTimersEnabled;

        projectDto.status = projectRealmModel.status;

        projectDto.subStatus = projectRealmModel.subStatus;

        projectDto.defaultPrivacy = projectRealmModel.defaultPrivacy;

        projectDto.createdOn = projectRealmModel.createdOn;

        projectDto.category = new CategoryDto(projectRealmModel.category.name, projectRealmModel.category.id);

        projectDto.filesAutoNewVersion = projectRealmModel.filesAutoNewVersion;

        projectDto.tags = tagModelToDtoListMapper.map(projectRealmModel.tags);

        projectDto.logo = projectRealmModel.logo;

        projectDto.startDate = projectRealmModel.startDate;

        projectDto.id = projectRealmModel.id;

        projectDto.lastChangeOn = projectRealmModel.lastChangeOn;

        projectDto.people = peopleModelToDtoListMapper.map(projectRealmModel.people);

        projectDto.endDate = projectRealmModel.endDate;

        projectDto.name = projectRealmModel.name;

        projectDto.privacyEnabled = projectRealmModel.privacyEnabled;

        projectDto.description = projectRealmModel.description;

        projectDto.announcement = projectRealmModel.announcement;

        projectDto.isProjectAdmin = projectRealmModel.isProjectAdmin;

        projectDto.startPage = projectRealmModel.startPage;

        projectDto.notifyEveryone = projectRealmModel.notifyEveryone;

        projectDto.announcementHTML = projectRealmModel.announcementHTML;

        return projectDto;
    }

}
