package com.example.recyclerview.ejemplo5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;



public class Lista5Fragment extends Fragment {

    private static final String ARG_LIST = "listado";

    public Lista5Fragment() {
    }

    /* Método factoría que recibe el número de columnas del RecyclerView */
    public static Lista5Fragment newInstance() {
        return new Lista5Fragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new Custom5Adapter(Ej5Activity.lenguajes));

        return view;
    }
}