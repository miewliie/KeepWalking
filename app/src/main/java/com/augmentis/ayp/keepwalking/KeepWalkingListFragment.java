package com.augmentis.ayp.keepwalking;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Apinya on 7/27/2016.
 */
public class KeepWalkingListFragment extends Fragment {

    private RecyclerView _keepWalkingRecyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.keep_walking_list, container, false);

        _keepWalkingRecyclerView = (RecyclerView) v.findViewById(R.id.keep_walking_recycler_view);
        _keepWalkingRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return v;
    }

    private void updateUI() {
        KeepWalkingLab keepWalkingLab = KeepWalkingLab.getInstance(getActivity());
        List<KeepWalking> keepWalkings = keepWalkingLab.getKeepWalking();
//
//        if (_adapter == null) {
//            _adapter = new CrimeAdapter(crimes);
//            _crimeRecyclerView.setAdapter(_adapter);
//        }else {
//            if(crimePos != null) {
//                for (Integer pos : crimePos) {
//                    _adapter.notifyItemChanged(pos);
//                    Log.d(TAG, "notify change at " + pos);
//                }
//            }

//            _adapter.notifyItemChanged(crimePos);
//            _adapter.notifyDataSetChanged();
//            _adapter.notifyItemRangeChanged(crimePos, crimes.size());
//            Log.d(TAG, "notify add ");
//        }
    }

    private class KeepWalkingHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public KeepWalkingHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
