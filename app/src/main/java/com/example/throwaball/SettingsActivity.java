package com.example.throwaball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    private static SeekBar seekBar;
    private static TextView text_View;
    private int progress_value = 0;
    private Button btnUpd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        text_View = findViewById(R.id.txtView);
        seekBar = findViewById(R.id.seekBar);
        btnUpd = findViewById(R.id.btnUpdate);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value = progress;
                text_View.setText(Integer.toString(progress_value));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                text_View.setText(Integer.toString(progress_value));
            }
        });


        btnUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent sendBack = new Intent();
                final Bundle bundle = new Bundle();
                bundle.putInt(MainActivity.INT_EXTRA, progress_value);
                sendBack.putExtras(bundle);
                setResult(RESULT_OK, sendBack);
                finish();
            }
        });
    }
}
