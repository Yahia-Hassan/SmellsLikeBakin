package com.teamtreehouse.smellslikebakin;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements ListFragment.OnRecipeSelectedInterface,
        GridFragment.OnRecipeSelectedInterface {
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String LIST_FRAGMENT = "list_fragment";
    public static final String VIEWPAGER_FRAGMENT = "viewpager_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean isTablet = getResources().getBoolean(R.bool.is_tablet);

        if (!isTablet) {
            ListFragment savedFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
            if (savedFragment == null) {
                Log.d(TAG, "onCreate called");
                ListFragment fragment = new ListFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.placeHolder, fragment, LIST_FRAGMENT)
                        .commit();
            }
        } else {
            GridFragment savedFragment = (GridFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
            if (savedFragment == null) {
                Log.d(TAG, "onCreate called");
                GridFragment fragment = new GridFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.placeHolder, fragment, LIST_FRAGMENT)
                        .commit();
            }
        }




    }

    @Override
    public void onListRecipeSelected(int index) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.placeHolder, fragment, VIEWPAGER_FRAGMENT)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onGridRecipeSelected(int index) {
        DualPaneFragment fragment = new DualPaneFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.placeHolder, fragment, VIEWPAGER_FRAGMENT)
                .addToBackStack(null)
                .commit();
    }
}
