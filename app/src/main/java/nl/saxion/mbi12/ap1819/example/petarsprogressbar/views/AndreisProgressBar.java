package nl.saxion.mbi12.ap1819.example.petarsprogressbar.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import nl.saxion.mbi12.ap1819.example.petarsprogressbar.R;

public class AndreisProgressBar extends LinearLayout {
    public AndreisProgressBar(Context context) {
        super(context);
        init();
    }

    public AndreisProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AndreisProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public AndreisProgressBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.view_andreisprogressbar, this);

//        TextView tvTest = new TextView(getContext());
//        tvTest.setText("Testing");
//        tvTest.setId(tvTest.generateViewId());
//        tvTest.setLayoutParams(generateDefaultLayoutParams());
//
//        this.addView(tvTest);
    }
}
