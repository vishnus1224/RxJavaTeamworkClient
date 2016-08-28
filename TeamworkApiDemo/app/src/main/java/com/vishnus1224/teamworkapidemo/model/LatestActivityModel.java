package com.vishnus1224.teamworkapidemo.model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Vishnu on 8/28/2016.
 */
public class LatestActivityModel extends RealmObject {

    public String projectId;

    @PrimaryKey
    public String itemId;
    
    public String fromUserAvatarUrl;

    public String description;

    public String forUsername;

    public String publicInfo;

    public String forUserId;

    public String itemLink;

    public Date dateTime;

    public String activityType;

    public String companyId;

    public String projectName;

    public String latestActivityType;

    public String link;

    public String extraDescription;

    public String isPrivate;

    public String companyName;

    public String id;

    public Date dueDate;

    public String lockDownId;

    public String fromUsername;

    public String type;

    public String forUserAvatarUrl;

    public String userId;
}
