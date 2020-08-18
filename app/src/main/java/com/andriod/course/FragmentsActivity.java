package com.andriod.course;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentsActivity extends AppCompatActivity {
    OneFragment oneFragment;
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);
//        oneFragment = OneFragment.newInstance("", "");
//        openFragment(OneFragment.newInstance("", ""));

//        findViewById(R.id.remove_fragment).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                removeFragment(OneFragment.newInstance("", ""));
//            }
//        });

        bottomNavigation = findViewById(R.id.bottom_navigation);
        BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        openFragment(OneFragment.newInstance("id", "name"));
                        return true;
                    case R.id.navigation_sms:
                        openFragment(TwoFragment.newInstance("", ""));
                        return true;
                    case R.id.navigation_notifications:
                        openFragment(ThreeFragment.newInstance("", ""));
                        return true;
                }
                return false;
            }
        };
        bottomNavigation.setOnNavigationItemSelectedListener
                (navigationItemSelectedListener);
        openFragment(OneFragment.newInstance("", ""));

    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
//        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void removeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onBackPressed() {
        if (bottomNavigation.getSelectedItemId() != R.id.navigation_home)
            bottomNavigation.setSelectedItemId(R.id.navigation_home);
        else
            super.onBackPressed();
    }
}