package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.teamworkapidemo.model.CategoryRealmModel;
import com.vishnus1224.teamworkapidemo.model.CompanyRealmModel;
import com.vishnus1224.teamworkapidemo.model.ProjectDto;
import com.vishnus1224.teamworkapidemo.model.ProjectRealmModel;

import javax.inject.Inject;


/**
 * Created by vishnu on 02/09/16.
 */
public class ProjectDtoToModelMapper implements Mapper<ProjectDto, ProjectRealmModel> {

    private TagDtoToModelListMapper tagDtoToModelListMapper;

    private PeopleDtoToModelListMapper peopleDtoToModelListMapper;

    @Inject
    public ProjectDtoToModelMapper(TagDtoToModelListMapper tagDtoToModelListMapper, PeopleDtoToModelListMapper peopleDtoToModelListMapper) {

        this.tagDtoToModelListMapper = tagDtoToModelListMapper;

        this.peopleDtoToModelListMapper = peopleDtoToModelListMapper;
    }

    @Override
    public ProjectRealmModel map(ProjectDto projectDto) {

        ProjectRealmModel projectRealmModel = new ProjectRealmModel();

        projectRealmModel.replyByEmailEnabled = projectDto.replyByEmailEnabled;

        projectRealmModel.starred = projectDto.starred;

        projectRealmModel.showAnnouncement = projectDto.showAnnouncement;

        projectRealmModel.harvestTimersEnabled = projectDto.harvestTimersEnabled;

        projectRealmModel.status = projectDto.status;

        projectRealmModel.subStatus = projectDto.subStatus;

        projectRealmModel.defaultPrivacy = projectDto.defaultPrivacy;

        projectRealmModel.createdOn = projectDto.createdOn;

        projectRealmModel.category = new CategoryRealmModel(projectDto.category.name, projectDto.category.id);

        projectRealmModel.filesAutoNewVersion = projectDto.filesAutoNewVersion;

        projectRealmModel.tags = tagDtoToModelListMapper.map(projectDto.tags);

        projectRealmModel.logo = projectDto.logo;

        projectRealmModel.startDate = projectDto.startDate;

        projectRealmModel.id = projectDto.id;

        projectRealmModel.lastChangeOn = projectDto.lastChangeOn;

        projectRealmModel.people = peopleDtoToModelListMapper.map(projectDto.people);

        projectRealmModel.endDate = projectDto.endDate;

        projectRealmModel.company = new CompanyRealmModel(projectDto.company.name, projectDto.company.isOwner,
                projectDto.company.id);

        projectRealmModel.name = projectDto.name;

        projectRealmModel.privacyEnabled = projectDto.privacyEnabled;

        projectRealmModel.description = projectDto.description;

        projectRealmModel.announcement = projectDto.announcement;

        projectRealmModel.isProjectAdmin = projectDto.isProjectAdmin;

        projectRealmModel.startPage = projectDto.startPage;

        projectRealmModel.notifyEveryone = projectDto.notifyEveryone;

        projectRealmModel.announcementHTML = projectDto.announcementHTML;

        return projectRealmModel;
    }
}
