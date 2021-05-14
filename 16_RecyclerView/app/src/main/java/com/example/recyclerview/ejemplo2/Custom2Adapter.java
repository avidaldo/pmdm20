package com.example.recyclerview.ejemplo2;


import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;

import java.util.List;

public class Custom2Adapter extends RecyclerView.Adapter<Custom2Adapter.ViewHolder> {

    private List<String> listadoDatos;

    public Custom2Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elemento, parent, false);

        return new ViewHolder(view);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);

            // Aquí podemos setear un escuchador para cada elemento
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),
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



    public Custom2Adapter(List<String> dataSet) {
        listadoDatos = dataSet;
    }



    @Override
    public void onBindViewHolder(Custom2Adapter.ViewHolder holder, int position) {
        String lenguaje = listadoDatos.get(position);
        holder.textView.setText(lenguaje);

        /* Modificamos el diseño de cada elemento en función de su posición */

        if (position % 2 == 0) { // Si la posición de la fila es par
            holder.textView.setBackgroundColor(Color.CYAN);
            holder.textView.setTextColor(Color.BLUE);
            holder.textView.setGravity(Gravity.RIGHT);
        } else { // Si la posición es impar
            holder.textView.setBackgroundColor(Color.TRANSPARENT);
            holder.textView.setTextColor(Color.BLUE);
            holder.textView.setGravity(Gravity.LEFT);
        }

    }

    @Override
    public int getItemCount() {
        return listadoDatos.size();
    }
}
