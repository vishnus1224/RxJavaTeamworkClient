package com.vishnus1224.teamworkapidemo.model;

import java.util.Date;
import java.util.List;

/**
 * Created by vishnu on 02/09/16.
 */
public class ProjectDto {

    public boolean replyByEmailEnabled;

    public boolean starred;

    public boolean showAnnouncement;

    public boolean harvestTimersEnabled;

    public String status;

    public String subStatus;

    public String defaultPrivacy;

    public Date createdOn;

    public CategoryDto category;

    public boolean filesAutoNewVersion;

    public List<TagDto> tags;

    public String logo;

    public Date startDate;

    public String id;

    public Date lastChangeOn;

    public List<PeopleDto> people;

    public Date endDate;

    public DefaultsDto defaults;

    public CompanyDto company;

    public String name;

    public boolean privacyEnabled;

    public String description;

    public String announcement;

    public boolean isProjectAdmin;

    public String startPage;

    public boolean notifyEveryone;

    public String announcementHTML;
}
