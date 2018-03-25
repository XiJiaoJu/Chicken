package com.example.chengzhiyuan.models.ui.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

/**
 * Created by chengzhiyuan on 2018/3/24.
 */

public class PIView extends View {

    private static final String TAG = "PIView";

    private Paint mPaint;
    private int centerX;
    private int centerY;
    private int[] colors = {Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN, Color.GRAY, Color.BLACK};
    private final int parts = 15;
    private Random random;

    public PIView(Context context) {
        this(context, null);
    }

    public PIView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PIView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);

        this.random = new Random();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "pi view onDraw: ");
        canvas.save();
        // draw pi graph
        canvas.translate(centerX, centerY);
        float pair = 360 / parts;
        float start = 0;
        RectF rectF = new RectF(-300, -300, 300, 300);
        for (int i = 1; i <= parts; i++) {
            int color = colors[random.nextInt(colors.length)];
            mPaint.setColor(color);
            canvas.drawArc(rectF, start, pair, true, mPaint);
            start += pair;
        }

        // draw text
        int h = getFontHeight(30);
        mPaint.setTextSize(30);
        mPaint.setColor(Color.WHITE);
        canvas.rotate(pair / 2);
        for (int i = 1; i <= parts; i++) {
            String text = String.valueOf(i);
            canvas.drawText(text, 200, h / 4, mPaint);
            canvas.rotate(pair);
        }
        canvas.restore();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;
    }

    /**
     * get font height
     * @param fontSize font size
     * @return returen height with int
     */
    public int getFontHeight(float fontSize) {
        Paint paint = new Paint();
        paint.setTextSize(fontSize);
        Paint.FontMetrics fm = paint.getFontMetrics();
        return (int) Math.ceil(fm.descent - fm.top) + 2;
    }


}
