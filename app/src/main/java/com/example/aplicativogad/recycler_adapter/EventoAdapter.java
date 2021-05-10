package com.example.aplicativogad.recycler_adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicativogad.EventoActivity;
import com.example.aplicativogad.R;
import com.example.aplicativogad.entidades.Evento;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.ViewHolder> {
    private List<Evento> dato;
    private LayoutInflater inflater;
    private Context context;

    public EventoAdapter(List<Evento> dato, Context context) {
        this.dato = dato;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public EventoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.elemento_lista, null);
        return new EventoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventoAdapter.ViewHolder holder, final int position) {
        holder.bindData(dato.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EventoActivity.class);
                intent.putExtra("id", getItem(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dato.size();
    }

    public Evento getItem(int position) {
        return dato.get(position);
    }

    public void setItems(List<Evento> items) {
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

        void bindData(final Evento item) {

            Picasso.get().load(item.getImgPath())
                    .error(R.drawable.gastronomia)
                    .into(img);

            titulo.setText(item.getTitulo());
            descripcion.setText(item.getDescripcion());

        }
    }
}
