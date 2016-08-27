package com.vishnus1224.teamworkapidemo.manager;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.vishnus1224.teamworkapidemo.ui.transformation.CircularImageTransformation;

/**
 * Created by Vishnu on 8/27/2016.
 */
public class PicassoImageManager implements ImageManager {

    private Context context;

    public PicassoImageManager(Context context) {
        this.context = context;
    }

    @Override
    public void loadCircularImageFromUrl(String url, ImageView imageView) {

        Picasso.with(context).load(url).fit().transform(new CircularImageTransformation()).into(imageView);

    }
}
