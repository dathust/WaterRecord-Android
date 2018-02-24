package com.wr.datpt.waterrecord.View.MainView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wr.datpt.waterrecord.R;
import com.wr.datpt.waterrecord.View.HomeView.HomeView;

/**
 * Created by DatPT on 01/02/2018.
 */

public class StartView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startview);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {

                } finally {
                    Intent intentHome = new Intent(StartView.this, HomeView.class);
                    startActivity(intentHome);
                }
            }
        });

        thread.start();
    }
}
