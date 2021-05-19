package com.example.recyclerview.ejemplo4;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerview.R;
import com.example.recyclerview.ejemplo3.Custom3Adapter;

import java.util.ArrayList;
import java.util.List;


public class ListaFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";

    private int mColumnCount = 1; // Número de columnas inicializado con valor por defecto

    private List<LenguajeProg> lenguajes;


    public ListaFragment() {
    }

    /* Método factoría que recibe el número de columnas del RecyclerView */
    public static ListaFragment newInstance(int columnCount) {
        ListaFragment fragment = new ListaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) { // Si recibe argumentos en el Bundle, se modifica el atributo
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        lenguajes = new ArrayList<>();
        lenguajes.add(new LenguajeProg("Java", R.drawable.java));
        lenguajes.add(new LenguajeProg("Kotlin", R.drawable.kotlin));
        lenguajes.add(new LenguajeProg("JavaScript", R.drawable.javascript));
        lenguajes.add(new LenguajeProg("Swift", R.drawable.swift));
        lenguajes.add(new LenguajeProg("Python", R.drawable.python));
        lenguajes.add(new LenguajeProg("PHP", R.drawable.php));
        lenguajes.add(new LenguajeProg("C#", R.drawable.csharp));
        lenguajes.add(new LenguajeProg("Go", R.drawable.go));
        lenguajes.add(new LenguajeProg("Rust", R.drawable.rust));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) { // Garantiza que la vista que se acaba de inflar sea un RecyclerView
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) { // Setea el LayoutManager adecuado al número de columnas deseado
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            // Setea el adaptador personalizado
            recyclerView.setAdapter(new Custom3Adapter(lenguajes));
        }
        return view;
    }
}