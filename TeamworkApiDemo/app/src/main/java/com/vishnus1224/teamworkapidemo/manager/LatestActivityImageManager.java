package com.vishnus1224.teamworkapidemo.manager;

import com.vishnus1224.teamworkapidemo.R;

/**
 * Manager for handling image operations for the latest activity.
 * Created by Vishnu on 8/27/2016.
 */
public class LatestActivityImageManager {

    public LatestActivityImageManager() {
    }

    /**
     * Gets the correct icon based on the type of the activity.
     * @param activityType The type of the activity. e.g project, task etc.
     * @return The drawable resource id.
     */
    public int getIconForLatestActivity(String activityType){

        if(activityType.equalsIgnoreCase("project")){

            return android.R.drawable.checkbox_on_background;

        }else if(activityType.equalsIgnoreCase("task")){

            return android.R.drawable.btn_star_big_on;

        }else{

            return R.mipmap.ic_launcher;

        }
    }
}
