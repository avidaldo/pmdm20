package com.example.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragments.R;

public class RedFragment extends Fragment {

    private OnOptionMenuSelectedListener mListener;


    public RedFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_red, container, false);

        view.findViewById(R.id.buttonRed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cambiacontenedor(OnOptionMenuSelectedListener.AZUL);

            }
        });



        return view;
    }



    @Override    // Método lanzado cuando el fragment se asocia con la Activity
    public void onAttach(Context activity) {
        super.onAttach(activity);

         /* Asignamos una referencia a la activity que contiene este método; la cual, para poder interactuar
         necesita implementar la interfaz que hemos definido con nuestro escuchador */
        try {
            mListener = (OnOptionMenuSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()  + " debe implementar OnOptionMenuSelectedListener");
        }
    }
}