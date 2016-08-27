package com.vishnus1224.teamworkapidemo.ui.transformation;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.squareup.picasso.Transformation;

/**
 * Created by Vishnu on 8/27/2016.
 */
public class CircularImageTransformation implements Transformation {

    @Override
    public Bitmap transform(Bitmap source) {

        int sourceWidth = source.getWidth();
        int sourceHeight = source.getHeight();

        float radius = Math.min(sourceWidth, sourceHeight);

        Bitmap bitmap = Bitmap.createBitmap(sourceWidth, sourceHeight, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();
        BitmapShader shader =
                new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);

        paint.setShader(shader);
        paint.setAntiAlias(true);

        canvas.drawCircle(sourceWidth * 0.5f, sourceHeight * 0.5f, radius * 0.5f, paint);

        source.recycle();

        return bitmap;
    }

    @Override
    public String key() {
        return "circle";
    }
}
