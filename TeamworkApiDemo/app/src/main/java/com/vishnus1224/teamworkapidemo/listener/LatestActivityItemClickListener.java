package com.vishnus1224.teamworkapidemo.listener;

import com.vishnus1224.teamworkapidemo.model.LatestActivityModel;

/**
 * Created by Vishnu on 8/27/2016.
 */
public interface LatestActivityItemClickListener {

    void onProjectClicked(LatestActivityModel latestActivityModel);

    void onTaskClicked(LatestActivityModel latestActivityModel);

    void onAvatarClicked(LatestActivityModel latestActivityModel);
}
