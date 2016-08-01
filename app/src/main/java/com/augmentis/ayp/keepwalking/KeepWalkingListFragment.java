package com.augmentis.ayp.keepwalking;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.UUID;

/**
 * Created by Apinya on 7/27/2016.
 */
public class KeepWalkingListFragment extends Fragment {

    private static final int REQUEST_DETAIL = 122;
    private static final String DIALOG_DETAIL = "KeepWalkingListFragment.DIALOG_DETAIL";
    private RecyclerView _keepWalkingRecyclerView;
    protected static final String TAG = "KEEP_WALKING_LIST";
    private static final int REQUEST_UPDATED_KEEP_WALKING = 311;
    private KeepWalkingAdapter _adapter;

    private Integer[] keepWalkingPos;

    private KeepWalking _keepWalking;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.keep_walking_list, container, false);

        _keepWalkingRecyclerView = (RecyclerView) v.findViewById(R.id.keep_walking_recycler_view);
        _keepWalkingRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        final Button btnAdd = (Button) v.findViewById(R.id.add_button);
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {

//                if(_keepWalking == null){
//                    _keepWalking = new KeepWalking();
//                    _keepWalking.setKeepWalkingTitle("");
//                }

//                Intent intent = KeepWalkingActivity.newIntent(getActivity(), _keepWalking.getKeepWalkingId());
//                startActivityForResult(intent, REQUEST_UPDATED_KEEP_WALKING);
//
//                FragmentManager fm = getFragmentManager();
//                DetailDialog dD = DetailDialog.newInstance(null);
//                dD.setTargetFragment(KeepWalkingListFragment.this, REQUEST_DETAIL);
//                dD.show(fm, DIALOG_DETAIL);
//            }
//        });

        updateUI();
        return v;
    }

    private void updateUI() {
        KeepWalkingLab keepWalkingLab = KeepWalkingLab.getInstance(getActivity());
        List<KeepWalking> keepWalkings = keepWalkingLab.getKeepWalking();

        if (_adapter == null) {
            _adapter = new KeepWalkingAdapter(keepWalkings);
            _keepWalkingRecyclerView.setAdapter(_adapter);

        }else {
            if(keepWalkingPos != null) {
                for (Integer pos : keepWalkingPos) {
                    _adapter.notifyItemChanged(pos);
                    Log.d(TAG, "notify change at " + pos);
                }
            }

        }
    }

    private class KeepWalkingHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView _textTitle;
        public TextView _textDate;

        KeepWalking _keepWalking;
        int _position;

        public KeepWalkingHolder(View itemView) {
            super(itemView);

            _textTitle = (TextView) itemView.findViewById(R.id.list_item_keep_walking_text_view);
            _textDate = (TextView) itemView.findViewById(R.id.list_item_keep_walking_date_text_view);

            itemView.setOnClickListener(this);
        }

        public void bind(KeepWalking keepWalking , int position) {
            _keepWalking = keepWalking;
            _position = position;
            _textTitle.setText(_keepWalking.getKeepWalkingTitle());
            _textDate.setText(_keepWalking.getKeepWalkingDate().toString());

        }

        @Override
        public void onClick(View view) {
//
//            Log.d(TAG, "send position : " + _position);
//            Intent intent = KeepWalkingActivity.newIntent(getActivity(), _keepWalking.getKeepWalkingId());
//            startActivityForResult(intent, REQUEST_UPDATED_KEEP_WALKING);

            FragmentManager fm = getFragmentManager();
            DetailDialog dD = DetailDialog.newInstance(getActivity(), _keepWalking.getKeepWalkingId());
            dD.setTargetFragment(KeepWalkingListFragment.this, REQUEST_DETAIL);
            dD.show(fm, DIALOG_DETAIL);
        }
    }

    private class KeepWalkingAdapter extends RecyclerView.Adapter<KeepWalkingHolder>{

        private List<KeepWalking> _keepWalkings;

        public KeepWalkingAdapter(List<KeepWalking> keepWalkings){
            this._keepWalkings = keepWalkings;
        }

        @Override
        public KeepWalkingHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater.inflate(R.layout.list_item_keep_walking, parent, false);

            return new KeepWalkingHolder(v);
        }

        @Override
        public void onBindViewHolder(KeepWalkingHolder holder, int position) {

            KeepWalking keepWalking = _keepWalkings.get(position);
            holder.bind(keepWalking, position);
        }

        @Override
        public int getItemCount() {
            return _keepWalkings.size();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.keep_walking_add, menu);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_new_keep_walking:

                FragmentManager fm = getFragmentManager();
                DetailDialog dD = DetailDialog.newInstance(getActivity(),null);
                dD.setTargetFragment(KeepWalkingListFragment.this, REQUEST_DETAIL);
                dD.show(fm, DIALOG_DETAIL);

                return true;// return true is nothing to do after this Law Na

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
}
