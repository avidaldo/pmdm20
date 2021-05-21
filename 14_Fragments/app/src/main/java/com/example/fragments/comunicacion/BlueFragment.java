package com.example.fragments.comunicacion;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fragments.R;

import static com.example.fragments.comunicacion.OnOptionMenuSelectedListener.ROJO;


public class BlueFragment extends Fragment {

    private OnOptionMenuSelectedListener mListener;

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

        // view es la vista del fragment que se ha creado. Podemos en ella buscar elementos.
        Button btnmenu1 = view.findViewById(R.id.buttonBlue);

        // asignamos un escuchador al botón
        btnmenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.cambiacontenedor(ROJO);

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