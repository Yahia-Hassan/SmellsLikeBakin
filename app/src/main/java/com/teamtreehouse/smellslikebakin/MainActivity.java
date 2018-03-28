package com.teamtreehouse.smellslikebakin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment fragment = new ListFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.placeHolder, fragment)
                .commit();

    }
}
