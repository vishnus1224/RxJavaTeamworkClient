package com.vishnus1224.teamworkapidemo.listener;

import com.vishnus1224.teamworkapidemo.model.ProjectDto;

/**
 * Listener for getting notified when a project is clicked in the project list screen.
 * Created by Vishnu on 9/5/2016.
 */
public interface ProjectListItemClickListener {

    void onProjectClicked(ProjectDto projectDto);

    void onProjectStarred(ProjectDto projectDto);

    void onProjectUnStarred(ProjectDto projectDto);

}
