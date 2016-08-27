package com.vishnus1224.rxjavateamworkclient.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by Vishnu on 8/27/2016.
 */
@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS_AND_ACCESSORS)
public class ProjectResponse {

    private boolean replyByEmailEnabled;

    private boolean starred;

    @JsonField(name = "show-announcement")
    private boolean showAnnouncement;

    @JsonField(name = "harvest-timers-enabled")
    private boolean harvestTimersEnabled;

    private String status;

    private String subStatus;

    private String defaultPrivacy;

    @JsonField(name = "created-on")
    private String createdOn;

    private Category category;

    private boolean filesAutoNewVersion;

    private String[] tags;

    private String logo;

    private String startDate;

    private String id;

    @JsonField(name = "last-changed-on")
    private String lastChangeOn;

    private String[] people;

    private String endDate;

    private String name;

    private boolean privacyEnabled;

    private String description;

    private String announcement;

    private boolean isProjectAdmin;

    @JsonField(name = "start-page")
    private String startPage;

    @JsonField(name = "notifyeveryone")
    private boolean notifyEveryone;

    private String announcementHTML;

    public boolean isReplyByEmailEnabled() {
        return replyByEmailEnabled;
    }

    public void setReplyByEmailEnabled(boolean replyByEmailEnabled) {
        this.replyByEmailEnabled = replyByEmailEnabled;
    }

    public boolean isStarred() {
        return starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    public boolean isShowAnnouncement() {
        return showAnnouncement;
    }

    public void setShowAnnouncement(boolean showAnnouncement) {
        this.showAnnouncement = showAnnouncement;
    }

    public boolean isHarvestTimersEnabled() {
        return harvestTimersEnabled;
    }

    public void setHarvestTimersEnabled(boolean harvestTimersEnabled) {
        this.harvestTimersEnabled = harvestTimersEnabled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    public String getDefaultPrivacy() {
        return defaultPrivacy;
    }

    public void setDefaultPrivacy(String defaultPrivacy) {
        this.defaultPrivacy = defaultPrivacy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isFilesAutoNewVersion() {
        return filesAutoNewVersion;
    }

    public void setFilesAutoNewVersion(boolean filesAutoNewVersion) {
        this.filesAutoNewVersion = filesAutoNewVersion;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastChangeOn() {
        return lastChangeOn;
    }

    public void setLastChangeOn(String lastChangeOn) {
        this.lastChangeOn = lastChangeOn;
    }

    public String[] getPeople() {
        return people;
    }

    public void setPeople(String[] people) {
        this.people = people;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrivacyEnabled() {
        return privacyEnabled;
    }

    public void setPrivacyEnabled(boolean privacyEnabled) {
        this.privacyEnabled = privacyEnabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public boolean isProjectAdmin() {
        return isProjectAdmin;
    }

    public void setProjectAdmin(boolean projectAdmin) {
        isProjectAdmin = projectAdmin;
    }

    public String getStartPage() {
        return startPage;
    }

    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

    public boolean isNotifyEveryone() {
        return notifyEveryone;
    }

    public void setNotifyEveryone(boolean notifyEveryone) {
        this.notifyEveryone = notifyEveryone;
    }

    public String getAnnouncementHTML() {
        return announcementHTML;
    }

    public void setAnnouncementHTML(String announcementHTML) {
        this.announcementHTML = announcementHTML;
    }
}
