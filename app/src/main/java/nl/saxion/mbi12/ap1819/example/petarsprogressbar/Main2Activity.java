package nl.saxion.mbi12.ap1819.example.petarsprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import nl.saxion.mbi12.ap1819.example.petarsprogressbar.views.ColorSlidersView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final ColorSlidersView csv = findViewById(R.id.csvTwo);
        csv.setOnColorUpdateListener(new ColorSlidersView.OnColorUpdateListener() {
            @Override
            public void onRedUpdated(View view) {
                Toast.makeText(Main2Activity.this, "Red in activity 2 changed to " + csv.getRed(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onGreenUpdated(View view) {

            }

            @Override
            public void onBlueUpdated(View view) {

            }

            @Override
            public void onColorUpdated(View view) {

            }
        });
    }
}
