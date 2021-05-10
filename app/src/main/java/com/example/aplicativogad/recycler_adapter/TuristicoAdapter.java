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

import com.example.aplicativogad.TuristicoActivity;
import com.example.aplicativogad.R;
import com.example.aplicativogad.entidades.Turistico;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TuristicoAdapter extends RecyclerView.Adapter<TuristicoAdapter.ViewHolder> {

    private List<Turistico> dato;
    private LayoutInflater inflater;
    private Context context;

    public TuristicoAdapter(List<Turistico> dato, Context context) {
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
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.bindData(dato.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TuristicoActivity.class);
                intent.putExtra("id", getItem(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dato.size();
    }

    public Turistico getItem(int position) {
        return dato.get(position);
    }

    public void setItems(List<Turistico> items) {
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

        void bindData(final Turistico item) {

            Picasso.get().load(item.getImgPath())
                    .error(R.drawable.gastronomia)
                    .into(img);

            titulo.setText(item.getTitulo());
            descripcion.setText(item.getDescripcion());

        }
    }
}
