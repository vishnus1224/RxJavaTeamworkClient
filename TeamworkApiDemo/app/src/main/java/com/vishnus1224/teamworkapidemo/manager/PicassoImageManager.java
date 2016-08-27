package com.vishnus1224.teamworkapidemo.manager;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Vishnu on 8/27/2016.
 */
public class PicassoImageManager implements ImageManager {

    private Context context;

    public PicassoImageManager(Context context) {
        this.context = context;
    }

    @Override
    public void loadImageFromUrl(String url, ImageView imageView) {

        Picasso.with(context).load(url).fit().into(imageView);

    }
}
