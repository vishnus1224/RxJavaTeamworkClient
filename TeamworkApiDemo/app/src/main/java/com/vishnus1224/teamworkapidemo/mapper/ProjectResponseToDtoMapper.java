package com.vishnus1224.teamworkapidemo.mapper;

import com.vishnus1224.rxjavateamworkclient.model.ProjectResponse;
import com.vishnus1224.teamworkapidemo.model.CategoryDto;
import com.vishnus1224.teamworkapidemo.model.CompanyDto;
import com.vishnus1224.teamworkapidemo.model.DefaultsDto;
import com.vishnus1224.teamworkapidemo.model.ProjectDto;
import com.vishnus1224.teamworkapidemo.util.DateTimeHelper;

import java.text.ParseException;

import javax.inject.Inject;

/**
 * Created by vishnu on 02/09/16.
 */
public class ProjectResponseToDtoMapper implements Mapper<ProjectResponse,ProjectDto> {

    private TagToTagDtoListMapper tagToTagDtoListMapper;

    private DateTimeHelper dateTimeHelper;

    private PeopleIdToPeopleDtoListMapper peopleIdToPeopleDtoListMapper;

    @Inject
    public ProjectResponseToDtoMapper(TagToTagDtoListMapper tagToTagDtoListMapper, DateTimeHelper dateTimeHelper, PeopleIdToPeopleDtoListMapper peopleIdToPeopleDtoListMapper) {

        this.tagToTagDtoListMapper = tagToTagDtoListMapper;

        this.dateTimeHelper = dateTimeHelper;

        this.peopleIdToPeopleDtoListMapper = peopleIdToPeopleDtoListMapper;
    }

    @Override
    public ProjectDto map(ProjectResponse projectResponse) {

        ProjectDto projectDto = new ProjectDto();

        projectDto.replyByEmailEnabled = projectResponse.isReplyByEmailEnabled();

        projectDto.starred = projectResponse.isStarred();

        projectDto.showAnnouncement = projectResponse.isShowAnnouncement();

        projectDto.harvestTimersEnabled = projectResponse.isHarvestTimersEnabled();

        projectDto.status = projectResponse.getStatus();

        projectDto.subStatus = projectResponse.getSubStatus();

        projectDto.defaultPrivacy = projectResponse.getDefaultPrivacy();

        try {
            projectDto.createdOn = dateTimeHelper.createdOnDate(projectResponse.getCreatedOn());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        projectDto.category = new CategoryDto(projectResponse.getCategory().getName(), projectResponse.getCategory().getId());

        projectDto.filesAutoNewVersion = projectResponse.isFilesAutoNewVersion();

        projectDto.tags = tagToTagDtoListMapper.map(projectResponse.getTags());

        projectDto.logo = projectResponse.getLogo();

        try {
            projectDto.startDate = dateTimeHelper.startDate(projectResponse.getStartDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        projectDto.id = projectResponse.getId();

        try {
            projectDto.lastChangeOn = dateTimeHelper.lastChangedOnDate(projectResponse.getLastChangeOn());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        projectDto.people = peopleIdToPeopleDtoListMapper.map(projectResponse.getPeople());

        try {
            projectDto.endDate = dateTimeHelper.endDate(projectResponse.getEndDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }


        projectDto.company = new CompanyDto(projectResponse.getCompany().getName(),
                projectResponse.getCompany().getIsOwner(), projectResponse.getCompany().getId());

        projectDto.name = projectResponse.getName();

        projectDto.privacyEnabled = projectResponse.isPrivacyEnabled();

        projectDto.description = projectResponse.getDescription();

        projectDto.announcement = projectResponse.getAnnouncement();

        projectDto.isProjectAdmin = projectResponse.isProjectAdmin();

        projectDto.startPage = projectResponse.getStartPage();

        projectDto.notifyEveryone = projectResponse.isNotifyEveryone();

        projectDto.announcementHTML = projectResponse.getAnnouncementHTML();

        return projectDto;
    }
}
