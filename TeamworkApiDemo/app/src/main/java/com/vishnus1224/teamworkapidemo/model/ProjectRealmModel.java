package com.vishnus1224.teamworkapidemo.model;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by vishnu on 02/09/16.
 */
public class ProjectRealmModel extends RealmObject {

    public boolean replyByEmailEnabled;

    public boolean starred;

    public boolean showAnnouncement;

    public boolean harvestTimersEnabled;

    public String status;

    public String subStatus;

    public String defaultPrivacy;

    public Date createdOn;

    public CategoryRealmModel category;

    public boolean filesAutoNewVersion;

    public RealmList<TagRealmModel> tags;

    public String logo;

    public Date startDate;

    @PrimaryKey
    public String id;

    public Date lastChangeOn;

    public RealmList<PeopleRealmModel> people;

    public Date endDate;

    public DefaultsRealmModel defaults;

    public CompanyRealmModel company;

    public String name;

    public boolean privacyEnabled;

    public String description;

    public String announcement;

    public boolean isProjectAdmin;

    public String startPage;

    public boolean notifyEveryone;

    public String announcementHTML;
}
