package com.augmentis.ayp.keepwalking;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import java.util.UUID;

/**
 * Created by Apinya on 7/27/2016.
 */
public class KeepWalkingActivity extends SingleFragmentActivity {

    private static final String KEEP_WALKING_ID = "Keep_walking_activity.KeepWalkingId";
    private static final String KEEP_WALKING_POSITION = "Keep_walking_activity.KeepWalkingPos";


    public static Intent newIntent(Context context, UUID keepWalkingId) {
//
//        if (KEEPWALKINGID == null) {
//            KeepWalking keepWalking = new KeepWalking();
//            keepWalking.setKeepWalkingTitle("");
//        }
        Intent intent = new Intent(context, KeepWalkingActivity.class);
        intent.putExtra(KEEP_WALKING_ID, keepWalkingId);

        return intent;
    }

    @Override
    protected Fragment onCreateFragment(){
        UUID keepWalkingId = (UUID) getIntent().getSerializableExtra(KEEP_WALKING_ID);
        Integer position = (Integer) getIntent().getExtras().get(KEEP_WALKING_POSITION);
        Fragment fragment = KeepWalkingFragment.newInstance(keepWalkingId);
        return fragment;
    }

}
