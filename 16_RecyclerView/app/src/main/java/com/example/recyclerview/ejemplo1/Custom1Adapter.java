package com.example.recyclerview.ejemplo1;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;

import java.util.List;

public class Custom1Adapter extends RecyclerView.Adapter<Custom1Adapter.ViewHolder> {

    private List<String> listadoDatos;


    /**
     * Método al que se llama cada vez que se crea uno de los elementos de la lista
     * Infla una vista definida en "R.layout.elemento" para cada elemento
     */
    public Custom1Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elemento, parent, false);

        return new ViewHolder(view);
    }

    /**
     * Clase que describe la vista de cada elemento de la lista y su posición en esta.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);

            // Aquí podemos setear un escuchador para cada elemento
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(view.getContext(),
                            "Has elegido: " + ((TextView)v).getText(),
                            Toast.LENGTH_SHORT).show();
                }
            });
            textView = (TextView) view.findViewById(R.id.tv_elemento);
        }

        public TextView getTextView() {
            return textView;
        }
    }


    /**
     * El constructor recibirá los datos que queramos que el adaptador vuelque a cada elemento
     */
    public Custom1Adapter(List<String> dataSet) {
        listadoDatos = dataSet;
    }


    /** Método que vincula en cada elemento, según su posición, los datos correspondientes a
     * cada elemento
     */
    @Override
    public void onBindViewHolder(Custom1Adapter.ViewHolder holder, int position) {
        String lenguaje = listadoDatos.get(position);
        holder.textView.setText(lenguaje);

    }

    @Override
    public int getItemCount() {
        return listadoDatos.size();
    }
}
