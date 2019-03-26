package nl.saxion.mbi12.ap1819.example.petarsprogressbar.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import nl.saxion.mbi12.ap1819.example.petarsprogressbar.MainActivity;
import nl.saxion.mbi12.ap1819.example.petarsprogressbar.R;


public class ColorSlidersView extends LinearLayout {
    SeekBar sbRed, sbGreen, sbBlue;
    private OnColorUpdateListener onColorUpdateListener;

    public ColorSlidersView(Context context) {
        super(context);
        init();
    }

    public ColorSlidersView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ColorSlidersView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ColorSlidersView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.view_colorsliders, this);

        sbRed = findViewById(R.id.sbRed);
        sbGreen = findViewById(R.id.sbGreen);
        sbBlue= findViewById(R.id.sbBlue);

        sbRed.setMax(255);
        sbGreen.setMax(255);
        sbBlue.setMax(255);

        sbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // Do things when red seekbar changes
//                Updatable activity = (Updatable) getContext();
//                activity.update();
                if (onColorUpdateListener != null) {
                    onColorUpdateListener.onRedUpdated(ColorSlidersView.this);
                    onColorUpdateListener.onColorUpdated(ColorSlidersView.this);
                }
           }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void setRed(int red) {
        sbRed.setProgress(red);
    }

    public int getRed() {
        return sbRed.getProgress();
    }

    public interface Updatable {
        void update();
    }

    public interface OnColorUpdateListener {
        void onRedUpdated(View view);
        void onGreenUpdated(View view);
        void onBlueUpdated(View view);
        void onColorUpdated(View view);
    }

    public void setOnColorUpdateListener(OnColorUpdateListener listener) {
        this.onColorUpdateListener = listener;
    }
}
