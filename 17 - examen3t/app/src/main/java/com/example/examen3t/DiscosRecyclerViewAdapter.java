package com.example.examen3t;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;


public class DiscosRecyclerViewAdapter extends RecyclerView.Adapter<DiscosRecyclerViewAdapter.ViewHolder> {
    private Context context;

    private final List<Album> listadoAlbumes;

    public DiscosRecyclerViewAdapter(List<Album> items) {
        listadoAlbumes = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tvtitulo.setText(listadoAlbumes.get(position).getTitulo());
        holder.tvautor.setText(listadoAlbumes.get(position).getAutor());
        holder.caratula.setImageResource(listadoAlbumes.get(position).getImageId());

        holder.imageinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, holder.toString(), Snackbar.LENGTH_LONG)
                        .setAction("INFORMACIÓN", new View.OnClickListener() {
                            @Override
                            public void onClick(View v2) {
                                dialogoInfo(v.getContext(), position);
                            }
                        }).show();
            }
        });

        holder.imageremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listadoAlbumes.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, listadoAlbumes.size());
            }
        });

    }

    private void dialogoInfo(Context context, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(listadoAlbumes.get(position).toString());
        builder.setMessage(listadoAlbumes.get(position).getDescripcion());
        builder.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }


    @Override
    public int getItemCount() {
        return listadoAlbumes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvtitulo;
        public final TextView tvautor;
        public final ImageView caratula;
        public final ImageView imageinfo;
        public final ImageView imageremove;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvtitulo = (TextView) view.findViewById(R.id.tvtitulo);
            tvautor = (TextView) view.findViewById(R.id.tvautor);
            caratula = (ImageView) view.findViewById(R.id.imageView);
            imageinfo = (ImageView) view.findViewById(R.id.imageinfo);
            imageremove = (ImageView) view.findViewById(R.id.imageremove);
        }

        @Override
        public String toString() {
            return tvtitulo.getText() + " - " + tvautor.getText();
        }
    }
}