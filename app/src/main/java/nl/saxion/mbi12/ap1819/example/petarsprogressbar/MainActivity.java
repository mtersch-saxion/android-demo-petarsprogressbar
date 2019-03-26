package nl.saxion.mbi12.ap1819.example.petarsprogressbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import nl.saxion.mbi12.ap1819.example.petarsprogressbar.views.ColorSlidersView;
import nl.saxion.mbi12.ap1819.example.petarsprogressbar.views.PetarsProgressBarView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener /*, ColorSlidersView.Updatable*/ {
    PetarsProgressBarView ppbTest;
    ColorSlidersView csvTest;
    Button btnGetRed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ppbTest = findViewById(R.id.ppbTest);
        ppbTest.setMaxvalue(5);
        ppbTest.setValue(0);
//        ppbTest.setOnClickListener(this);

//        ppbTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                doOnClick(view);
//                int currentValue = ppbTest.getValue();
//                if (currentValue == ppbTest.getMaxvalue()) {
//                    currentValue = 0;
//                } else {
//                    currentValue++;
//                }
//                ppbTest.setValue(currentValue);
//            }
//        });

        csvTest = findViewById(R.id.csvTest);
        csvTest.setRed(255);

        csvTest.setOnColorUpdateListener(new ColorSlidersView.OnColorUpdateListener() {
            @Override
            public void onRedUpdated(View view) {
                Toast.makeText(MainActivity.this, "Red changed to:" + csvTest.getRed(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onGreenUpdated(View view) {

            }

            @Override
            public void onBlueUpdated(View view) {

            }

            @Override
            public void onColorUpdated(View view) {
                // Do nothing
            }
        });

        btnGetRed = findViewById(R.id.btnGetRed);
        btnGetRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    Toast.makeText(MainActivity.this, "Red value:" + csvTest.getRed(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        final Timer myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                int currentValue = ppbTest.getValue();
                if (currentValue == ppbTest.getMaxvalue()) {
//                    currentValue = 0;
                    myTimer.cancel();
                } else {
                    currentValue++;
                }
                ppbTest.setValue(currentValue);
            }
        }, 0, 1000);

    }
//
//    public void doOnClick(View view) {
//
//    }

    public void onClick(View view) {
//                doOnClick(view);
        int currentValue = ppbTest.getValue();
        if (currentValue == ppbTest.getMaxvalue()) {
            currentValue = 0;
        } else {
            currentValue++;
        }
        ppbTest.setValue(currentValue);
    }

//    public void update() {
//        Toast.makeText(MainActivity.this, "Red value:" + csvTest.getRed(), Toast.LENGTH_SHORT).show();
//    }
}
