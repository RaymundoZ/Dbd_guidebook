package com.raymundo.dbd_guidebook;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int mode = View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(mode);
        setContentView(R.layout.activity_main);
        init();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = manager.findFragmentByTag(LibraryFragment.getTAG());
        if (fragment == null)
            fragment = LibraryFragment.newInstance();
        transaction.replace(R.id.container, fragment, LibraryFragment.getTAG()).commit();
        final Fragment finalFragment = fragment;
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.itemLibrary:
                        if (!finalFragment.equals(manager.findFragmentByTag(LibraryFragment.getTAG())))
                            transaction.replace(R.id.container, finalFragment, LibraryFragment.getTAG());
                        break;
                    case R.id.itemDlc:
                        break;
                    case R.id.itemUpdates:
                        break;
                    case R.id.itemSettings:
                        break;
                }
                return true;
            }
        });
    }

    private void init() {
        navigationView = findViewById(R.id.bottomNavigation);
    }

}