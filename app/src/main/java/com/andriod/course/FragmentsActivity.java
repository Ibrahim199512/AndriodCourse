package com.andriod.course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class FragmentsActivity extends AppCompatActivity {
    OneFragment oneFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);
        oneFragment = OneFragment.newInstance("", "");
        openFragment(OneFragment.newInstance("", ""));

        findViewById(R.id.remove_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFragment(OneFragment.newInstance("", ""));
            }
        });
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void removeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        getSupportFragmentManager().popBackStack();
    }
}