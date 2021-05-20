package com.example.recyclerview.ejemplo5;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerview.R;

import java.util.List;

public class Custom5Adapter extends RecyclerView.Adapter<Custom5Adapter.ViewHolder> {

    private Context context;

    private List<LenguajeProg5> listadoDatos;


    public Custom5Adapter(List<LenguajeProg5> dataSet) {
        listadoDatos = dataSet;
    }


    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Recuperamos el contexto y lo dejamos en una variable global para poder referenciarlo después.
        context = parent.getContext();

        View view = LayoutInflater.from(context)
                .inflate(R.layout.elemento6, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(listadoDatos.get(position).nombre);
        // holder.imageView.setImageResource(listadoDatos.get(position).getIdImagen());

        /* Utilizando la libreía externa Glide (https://bumptech.github.io/glide/) */
        Glide.with(context)
                // Busca en internet la ruta de una imagen
                .load(listadoDatos.get(position).urlImagen)
                // Indicamos una imagen local para usar mientras no se recupera la de Internet
                .placeholder(R.drawable.generica)
                // Indicamos la vista de destino
                .into(holder.imageView);


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
                        "Has elegido: " + ((TextView) v).getText(),
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

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listadoDatos.remove(position);
                // notificamos la eliminación del elemento
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, listadoDatos.size());
            }
        });


    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textView;
        public final ImageView imageView;
        public final ImageView remove;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textView = (TextView) view.findViewById(R.id.textView);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            remove = (ImageView) view.findViewById(R.id.remove);
        }
        public TextView getTextView() {
            return textView;
        }
    }



    @Override
    public int getItemCount() {
        return listadoDatos.size();
    }
}
