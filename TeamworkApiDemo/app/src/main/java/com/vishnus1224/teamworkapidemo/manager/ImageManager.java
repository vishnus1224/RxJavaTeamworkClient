package com.vishnus1224.teamworkapidemo.manager;

import android.widget.ImageView;

/**
 * For loading images in the application.
 * Created by Vishnu on 8/27/2016.
 */
public interface ImageManager {

    /**
     * Load the image from the url into the image view.
     * @param url Url of the image.
     * @param imageView View to load the image into.
     */
    void loadImageFromUrl(String url, ImageView imageView);
}
