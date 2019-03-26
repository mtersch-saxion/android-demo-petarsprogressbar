package nl.saxion.mbi12.ap1819.example.petarsprogressbar.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class PetarsProgressBarView extends View {
    Paint backgroundPaint, foregroundPaint;
    int value = 0, maxvalue = Integer.MAX_VALUE;

    public PetarsProgressBarView(Context context) {
        super(context);
        init();
    }

    public PetarsProgressBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PetarsProgressBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public PetarsProgressBarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        backgroundPaint = new Paint();
        backgroundPaint.setColor(Color.rgb(255, 192, 192));
        backgroundPaint.setStyle(Paint.Style.FILL);
        foregroundPaint = new Paint();
        foregroundPaint.setColor(Color.GREEN);
    }

    public void setValue(int value) {
        if (value >= 0 && value <= maxvalue) {
            this.value = value;
        }
        Log.d(getClass().getCanonicalName(), "value: " + value);

        invalidate();
    }

    public int getValue() {
        return value;
    }

    public void setMaxvalue(int maxvalue) {
        if (maxvalue > 0) {
            this.maxvalue = maxvalue;
        }
    }

    public int getMaxvalue() {
        return maxvalue;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = canvas.getWidth(), height = canvas.getHeight();

        canvas.drawRect(0, 0, width - 1, height - 1, backgroundPaint);
        canvas.drawRect(0,0,width * value/maxvalue, height - 1, foregroundPaint);
    }
}
