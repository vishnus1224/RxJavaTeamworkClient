package com.vishnus1224.teamworkapidemo.ui.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Vishnu on 9/5/2016.
 */
public class OneLetterImageView extends View {

    private String text;

    private Paint backgroundPaint;

    private Paint textPaint;

    public OneLetterImageView(Context context) {
        super(context);
    }


    public OneLetterImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OneLetterImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initBackgroundPaint();

        initTextPaint();
    }

    public void setText(String text) {

        this.text = text;

        invalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {

        int width = getWidth();
        int height = getHeight();

        canvas.drawArc(new RectF(getLeft(), getTop(), getRight(), getBottom()), 0, 360, true, backgroundPaint);

        canvas.drawText(text, (width * 0.5f), (height * 0.5f) -
                ((textPaint.descent() + textPaint.ascent()) * 0.5f), textPaint);

    }


    private void initBackgroundPaint() {

        backgroundPaint = new Paint();

        initPaint(backgroundPaint, true, Paint.Style.FILL, Color.BLUE);
    }

    private void initTextPaint() {

        textPaint = new TextPaint();

        textPaint.setTextSize(40);

        textPaint.setTextAlign(Paint.Align.CENTER);

        initPaint(textPaint, true, Paint.Style.STROKE, Color.WHITE);
    }

    private void initPaint(Paint paint, boolean antiAlias, Paint.Style style, int color) {

        paint.setAntiAlias(antiAlias);
        paint.setStyle(style);
        paint.setColor(color);

    }
}
