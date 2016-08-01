package com.augmentis.ayp.keepwalking;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by Apinya on 7/29/2016.
 */
public class DetailDialog extends DialogFragment implements DialogInterface.OnClickListener {

    private static final String KEEP_WALKING_ID = "DetailDialog.KEEP_WALKING_ID" ;
    private EditText editText;
    UUID keepWalkingId;
    KeepWalking keepWalking;

    public static DetailDialog newInstance(Context context, UUID keepWalkingId){
        DetailDialog dd = new DetailDialog();
        Bundle args = new Bundle();
        args.putSerializable(KEEP_WALKING_ID, keepWalkingId);
//        args.putSerializable("ARG_DATE", s);
        dd.setArguments(args);
        return dd;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View v =  LayoutInflater.from(getActivity()).inflate(R.layout.fragment_dialog_detail, null);

        keepWalkingId = (UUID) getArguments().getSerializable("KEEP_WALKING_ID");
        editText = (EditText) v.findViewById(R.id.title_text_view);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                KeepWalkingLab keepWalkingLab = KeepWalkingLab.getInstance(getActivity());
                if(keepWalkingId == null){
                    keepWalking = new KeepWalking();
                    keepWalking.setKeepWalkingTitle(editText.getText().toString());
                }else {
                    keepWalking = keepWalkingLab.getKeepWalkingByID(keepWalking.getKeepWalkingId());

                }

                keepWalkingLab.getKeepWalking().add(keepWalking);

            }
        });
        builder.setNegativeButton(android.R.string.cancel, this);

        if(keepWalking != null) {
            KeepWalkingLab keepWalkingLab = KeepWalkingLab.getInstance(getActivity());
            keepWalking = keepWalkingLab.getKeepWalkingByID(keepWalking.getKeepWalkingId());

            editText.setText(keepWalking.getKeepWalkingTitle());
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    keepWalking.setKeepWalkingTitle(charSequence.toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        return builder.create();
    }


    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

//        Toast.makeText(getActivity(), "Something is TRUE!", Toast.LENGTH_SHORT).show();
    }
}
