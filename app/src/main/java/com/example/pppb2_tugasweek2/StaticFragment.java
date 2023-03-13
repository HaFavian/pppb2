package com.example.pppb2_tugasweek2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class StaticFragment extends Fragment {

    public StaticFragment() {
        // Required empty public constructor
    }
    public static StaticFragment newinstance(){
        return new StaticFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragView = inflater.inflate(R.layout.fragment_static, container, false);

        return fragView;
    }
}