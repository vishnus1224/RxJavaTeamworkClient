package com.vishnus1224.teamworkapidemo.listener;

import com.vishnus1224.teamworkapidemo.model.LatestActivityDto;

/**
 * Created by Vishnu on 8/27/2016.
 */
public interface LatestActivityItemClickListener {

    void onProjectClicked(LatestActivityDto latestActivityDto);

    void onTaskClicked(LatestActivityDto latestActivityDto);

    void onAvatarClicked(LatestActivityDto latestActivityDto);
}
