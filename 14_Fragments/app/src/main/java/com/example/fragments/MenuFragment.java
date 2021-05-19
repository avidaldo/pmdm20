package com.example.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MenuFragment extends Fragment {

    private OnOptionMenuSelectedListener mListener;


    public MenuFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        // view es la vista del fragment que se ha creado. Podemos en ella buscar elementos.
        Button btnmenu1 = view.findViewById(R.id.btnmenu1);
        btnmenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cambiacontenedor(OnOptionMenuSelectedListener.AZUL);
            }
        });
        Button btnmenu2 = view.findViewById(R.id.btnmenu2);
        btnmenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cambiacontenedor(OnOptionMenuSelectedListener.ROJO);
            }
        });
/*        Button btnmenu3 = view.findViewById(R.id.btnmenu3);
        btnmenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cambiacontenedor(OnOptionMenuSelectedListener.VERDE);
            }
        });*/

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