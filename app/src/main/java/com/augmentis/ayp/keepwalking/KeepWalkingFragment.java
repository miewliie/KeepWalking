package com.augmentis.ayp.keepwalking;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class KeepWalkingFragment extends Fragment {

    private int position;
    private KeepWalking keepWalking;
    private EditText editText;
    private Button DateButton;
    private Button SaveButton;
    private KeepWalkingLab keepWalkingLab;

    private static final String KEEP_WALKING_ID = "KeepWalkingFragment.KEEP_WALKING_ID" ;
    private static final String KEEP_WALKING_POSITION = "KeepWalkingFragment.KEEP_WALKING_POSITION";

    public KeepWalkingFragment(){}

    public static KeepWalkingFragment newInstance(UUID keepWalkingId){
        Bundle args = new Bundle();
        args.putSerializable(KEEP_WALKING_ID, keepWalkingId);
//        args.putInt(KEEP_WALKING_POSITION, position);

        KeepWalkingFragment keepWalkingFragment = new KeepWalkingFragment();
        keepWalkingFragment.setArguments(args);
        return keepWalkingFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID keepWalkingId = (UUID) getArguments().getSerializable(KEEP_WALKING_ID);
        position  = getArguments().getInt(KEEP_WALKING_POSITION);
        keepWalking = KeepWalkingLab.getInstance(getActivity()).getKeepWalkingByID(keepWalkingId);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_keep_walking, container, false);

//        if (keepWalking == null) {
//            keepWalking = new KeepWalking();
//            keepWalking.setKeepWalkingTitle("");
//        }

        editText = (EditText) v.findViewById(R.id.keep_walking_title);
        editText.setText(keepWalking.getKeepWalkingTitle());
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence c, int i, int i1, int i2) {


                keepWalking.setKeepWalkingTitle(c.toString());
//                addThisPositionToResult(position);
            }

            @Override
            public void afterTextChanged(Editable c) {

            }
        });


        SaveButton = (Button) v.findViewById(R.id.btnsave);
        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


        return v;
    }

    private String getFormattedDate(Date date){
        return new SimpleDateFormat("dd MMMM yyyy").format(date);
    }

//    private void addThisPositionToResult(int position) {
//        if(getActivity() instanceof  CrimePagerActivity){
//            ((CrimePagerActivity) getActivity()).addPageUpdate(position);
//        }
//    }
}
