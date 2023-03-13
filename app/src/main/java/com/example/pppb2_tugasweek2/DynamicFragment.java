package com.example.pppb2_tugasweek2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class DynamicFragment extends Fragment {

    public DynamicFragment() {
        // Required empty public constructor
    }
    public static DynamicFragment newInstance(){
        return new DynamicFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View dynamic_frag = inflater.inflate(R.layout.fragment_dynamic, container, false);

        return dynamic_frag;
    }
}