package com.teamtreehouse.smellslikebakin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListFragment.OnRecipeSelectedInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment fragment = new ListFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.placeHolder, fragment)
                .commit();

    }

    @Override
    public void onListRecipeSelected(int index) {
        Toast.makeText(this, Recipes.names[index], Toast.LENGTH_SHORT).show();
    }
}
