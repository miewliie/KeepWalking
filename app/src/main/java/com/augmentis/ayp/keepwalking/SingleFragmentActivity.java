package com.augmentis.ayp.keepwalking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Apinya on 7/27/2016.
 */
public abstract class SingleFragmentActivity extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keep_walking);

//        Log.d(CrimeListFragment.TAG, "On create activity");

        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.fragment_container);


        if(f == null){
            f = onCreateFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, f)
                    .commit();
            //
        }else {
            //
        }

        Button btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingleFragmentActivity.this, KeepWalkingFragment.class);
                startActivity(intent);
            }
        });

    }

    protected abstract Fragment onCreateFragment();
}
