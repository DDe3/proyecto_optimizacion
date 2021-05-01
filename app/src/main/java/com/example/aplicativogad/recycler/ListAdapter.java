package com.example.aplicativogad.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicativogad.ElementoActivity;
import com.example.aplicativogad.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListElement> dato;
    private LayoutInflater inflater;
    private Context context;

    public ListAdapter(List<ListElement> dato, Context context) {
        this.dato = dato;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.elemento_lista, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(dato.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ElementoActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dato.size();
    }

    public void setItems(List<ListElement> items) {
        dato = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView titulo, descripcion;
        ViewHolder(View item) {
            super(item);
            img = item.findViewById(R.id.imgElemento);
            titulo = item.findViewById(R.id.tituloElemento);
            descripcion = item.findViewById(R.id.descElemento);
        }

        void bindData(final ListElement item) {

            img.setImageResource(R.drawable.logo_guangopolo); //       <---------------- CAMBIAR POR LA IMAGEN

            titulo.setText(item.getTitulo());
            descripcion.setText(item.getDescripcion());
        }
    }
}
