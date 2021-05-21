package com.example.fragments.basico;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.fragments.R;


public class BlueFragment extends Fragment {

    public BlueFragment() {
    }

    public static BlueFragment newInstance(String param1) {
        BlueFragment fragment = new BlueFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blue, container, false);
        return view;
    }



}