package com.vishnus1224.teamworkapidemo.manager;

import android.widget.ImageView;

import com.vishnus1224.teamworkapidemo.R;

/**
 * Manager for handling image operations for the latest activity.
 * Created by Vishnu on 8/27/2016.
 */
public class LatestActivityImageManager {

    private ImageManager imageManager;

    public LatestActivityImageManager(ImageManager imageManager) {

        this.imageManager = imageManager;

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

    /**
     * Load the image into image view.
     * @param imageUrl Url of the image to load.
     * @param imageView The image view to load the image into.
     */
    public void loadImage(String imageUrl, ImageView imageView){

        imageManager.loadCircularImageFromUrl(imageUrl, imageView);

    }
}
