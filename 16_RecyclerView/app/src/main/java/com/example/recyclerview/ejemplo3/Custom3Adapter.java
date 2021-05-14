package com.example.recyclerview.ejemplo3;


import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.LenguajeProg;
import com.example.recyclerview.R;

import java.util.List;

public class Custom3Adapter extends RecyclerView.Adapter<Custom3Adapter.ViewHolder> {

    private List<LenguajeProg> listadoDatos;

    public Custom3Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elemento3, parent, false);

        return new ViewHolder(view);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textView;
        public final ImageView imageView;

        public ViewHolder(View view) {
            super(view);

            /* Asignamos a variables la vista de cada elemento y sus vistas internas */
            mView = view;
            textView = (TextView) view.findViewById(R.id.textView);
            imageView = (ImageView) view.findViewById(R.id.imageView);


        }

        public TextView getTextView() {
            return textView;
        }
    }



    public Custom3Adapter(List<LenguajeProg> dataSet) {
        listadoDatos = dataSet;
    }



    @Override
    public void onBindViewHolder(Custom3Adapter.ViewHolder holder, int position) {
        holder.textView.setText(listadoDatos.get(position).getNombre());
        holder.imageView.setImageResource(listadoDatos.get(position).getIdImagen());


        /* Modificamos el color de cada elemento en función de su posición */
        if (position % 2 == 0) {
            holder.mView.setBackgroundColor(Color.CYAN);
            holder.textView.setTextColor(Color.BLUE);
        } else {
            holder.mView.setBackgroundColor(Color.TRANSPARENT);
            holder.textView.setTextColor(Color.GRAY);
        }

        holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),
                            "Has elegido: " +  ((TextView)v).getText(),
                            Toast.LENGTH_SHORT).show();
                }
            });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),
                        "Logo de : " + holder.textView.getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listadoDatos.size();
    }
}
