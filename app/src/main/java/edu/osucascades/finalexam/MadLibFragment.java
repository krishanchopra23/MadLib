package edu.osucascades.finalexam;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

//I tried to implement fragments and have recycler views connected
//Didn't have enough time

public class MadLibFragment extends Fragment {

    private RecyclerView mToDoRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_mad_lib, container, false);

        mToDoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }


    private class MadLibHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private MadLib mMadLib;


        public MadLibHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.activity_fragment, parent, false));
            itemView.setOnClickListener(this);

        }


        public void bind(MadLib madLib) {
            mMadLib = madLib;

        }


        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT);
        }
    }


        private class MadLibAdapter extends RecyclerView.Adapter<MadLibHolder> {


            @Override
            public MadLibHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
                return new MadLibHolder(layoutInflater, parent);
            }


            @Override
            public void onBindViewHolder(MadLibHolder holder, int position) {

            }


            @Override
            public int getItemCount() {
                return 1;
            }
        }
}

