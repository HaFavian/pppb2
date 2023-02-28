package com.example.pppb2_tugasweek2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class StaticFragment extends Fragment {

    public StaticFragment() {
        // Required empty public constructor
    }
    public static StaticFragment newInstance() {
        return new StaticFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_static, container, false);
    }
}