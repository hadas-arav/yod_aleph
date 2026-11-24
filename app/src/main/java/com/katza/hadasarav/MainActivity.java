package com.katza.hadasarav;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView flag;
    private SeekBar opacity;
    private SwitchCompat showMore;
    private LinearLayout actions;
    private Button unity;
    private Button pride;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectViews();
        setupSwitch();
        setupButtons();
        setupSeekBar();
    }

    private void connectViews() {
        flag = findViewById(R.id.imageView);
        opacity = findViewById(R.id.flagOpacity);
        showMore = findViewById(R.id.showMoreSwitch);
        actions = findViewById(R.id.actionsLayout);
        unity = findViewById(R.id.unityButton);
        pride = findViewById(R.id.prideButton);
    }

    private void setupSwitch() {
        showMore.setOnCheckedChangeListener((view, checked) -> {
            actions.setVisibility(checked ? View.VISIBLE : View.GONE);
        });
    }

    private void setupButtons() {
        unity.setOnClickListener(view ->
                showMessage(" כפתור 1"));

        pride.setOnClickListener(view ->
                showMessage("כפתור 2"));
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void setupSeekBar() {
        opacity.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekBar,
                                                  int progress,
                                                  boolean fromUser) {
                        flag.setAlpha(progress / 100.0f);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });
    }
}