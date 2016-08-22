package com.vishnus1224.rxjavateamworkclient.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by Vishnu on 8/22/2016.
 */
@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS_AND_ACCESSORS)
public class LatestActivityResponse {

    @JsonField(name = "project-id")
    private String projectId;

    @JsonField(name = "itemid")
    private String itemId;

    @JsonField(name = "from-user-avatar-url")
    private String fromUserAvatarUrl;

    private String description;

    @JsonField(name = "forusername")
    private String forUsername;

    @JsonField(name = "publicinfo")
    private String publicInfo;

    @JsonField(name = "foruserid")
    private String forUserId;

    @JsonField(name = "itemlink")
    private String itemLink;

    @JsonField(name = "datetime")
    private String dateTime;

    @JsonField(name = "activitytype")
    private String activityType;

    @JsonField(name = "company-id")
    private String companyId;

    @JsonField(name = "project-name")
    private String projectName;

    @JsonField(name = "latestActivityType")
    private String latestActivityType;

    private String link;

    @JsonField(name = "extradescription")
    private String extraDescription;

    @JsonField(name = "isprivate")
    private String isPrivate;

    @JsonField(name = "company-name")
    private String companyName;

    private String id;

    @JsonField(name = "due-date")
    private String dueDate;

    @JsonField(name = "lockdownId")
    private String lockDownId;

    @JsonField(name = "fromusername")
    private String fromUsername;

    private String type;

    @JsonField(name = "for-user-avatar-url")
    private String forUserAvatarUrl;

    @JsonField(name = "userid")
    private String userId;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getFromUserAvatarUrl() {
        return fromUserAvatarUrl;
    }

    public void setFromUserAvatarUrl(String fromUserAvatarUrl) {
        this.fromUserAvatarUrl = fromUserAvatarUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getForUsername() {
        return forUsername;
    }

    public void setForUsername(String forUsername) {
        this.forUsername = forUsername;
    }

    public String getPublicInfo() {
        return publicInfo;
    }

    public void setPublicInfo(String publicInfo) {
        this.publicInfo = publicInfo;
    }

    public String getForUserId() {
        return forUserId;
    }

    public void setForUserId(String forUserId) {
        this.forUserId = forUserId;
    }

    public String getItemLink() {
        return itemLink;
    }

    public void setItemLink(String itemLink) {
        this.itemLink = itemLink;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getLatestActivityType() {
        return latestActivityType;
    }

    public void setLatestActivityType(String latestActivityType) {
        this.latestActivityType = latestActivityType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getExtraDescription() {
        return extraDescription;
    }

    public void setExtraDescription(String extraDescription) {
        this.extraDescription = extraDescription;
    }

    public String getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(String isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getLockDownId() {
        return lockDownId;
    }

    public void setLockDownId(String lockDownId) {
        this.lockDownId = lockDownId;
    }

    public String getFromUsername() {
        return fromUsername;
    }

    public void setFromUsername(String fromUsername) {
        this.fromUsername = fromUsername;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForUserAvatarUrl() {
        return forUserAvatarUrl;
    }

    public void setForUserAvatarUrl(String forUserAvatarUrl) {
        this.forUserAvatarUrl = forUserAvatarUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
