package com.vishnus1224.teamworkapidemo.listener;

import com.vishnus1224.rxjavateamworkclient.model.LatestActivityResponse;

/**
 * Created by Vishnu on 8/27/2016.
 */
public interface LatestActivityItemClickListener {

    void onProjectClicked(LatestActivityResponse latestActivityResponse);

    void onTaskClicked(LatestActivityResponse latestActivityResponse);

    void onAvatarClicked(LatestActivityResponse latestActivityResponse);
}
