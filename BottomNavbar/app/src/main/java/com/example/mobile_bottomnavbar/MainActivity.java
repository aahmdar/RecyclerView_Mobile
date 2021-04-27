package com.example.mobile_bottomnavbar;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mobile_bottomnavbar.Fragments.FavoriteFragment;
import com.example.mobile_bottomnavbar.Fragments.MovieFragment;
import com.example.mobile_bottomnavbar.Fragments.TvShowFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private Map<Integer, Fragment> fragmentMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        fragmentMap = new HashMap<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        fragmentMap.put(R.id.menu_item_movie, MovieFragment.newInstance());
        fragmentMap.put(R.id.menu_item_tvshow, TvShowFragment.newInstance());
        fragmentMap.put(R.id.menu_item_favorite, FavoriteFragment.newInstance());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menu_item_tvshow);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = fragmentMap.get(item.getItemId());
        assert fragment != null;
        switch (item.getItemId()){
            case R.id.menu_item_movie:
                setActionBarTitle(getResources().getString(R.string.label_movie));
                break;
            case R.id.menu_item_favorite:
                setActionBarTitle(getResources().getString(R.string.label_favorite));
                break;
            case R.id.menu_item_tvshow:
                setActionBarTitle(getResources().getString(R.string.label_tvshow));
                break;
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
        return true;
    }
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}