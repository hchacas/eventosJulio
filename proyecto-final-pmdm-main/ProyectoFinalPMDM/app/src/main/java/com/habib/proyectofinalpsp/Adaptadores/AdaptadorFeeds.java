package com.habib.proyectofinalpsp.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.habib.proyectofinalpsp.Utils.Feed;
import com.julian.proyectofinalpsp.R;
import com.habib.proyectofinalpsp.Utils.Recetas;

import java.util.ArrayList;

public class AdaptadorFeeds extends RecyclerView.Adapter<AdaptadorFeeds.MyHolder> {

    private ArrayList<Feed> listaFeeds;
    private Context context;
    private OnRecetaListener listener;

    public AdaptadorFeeds(Context context) {
        this.listaFeeds = new ArrayList<>();
        this.context = context;
        this.listener=(OnRecetaListener) context;

    }



    public void agregarReceta (Feed feed){
        this.listaFeeds.add(feed);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fila_feed,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        Feed feed = listaFeeds.get(position);
        String uid="";
        holder.nombreReceta.setText(feed.getFecha());
        Glide.with(context).load(feed.getImagen()).placeholder(R.drawable.charla).into(holder.imagenReceta);
        holder.verDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // ejecutado con la pulsacion de la fila
              listener.onRecetaSelected(feed,uid);


            }
        });

    }

    @Override
    public int getItemCount() {
        return listaFeeds.size();
    }

    public interface OnRecetaListener{

        void onRecetaSelected(Feed feed,String uid);

    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView nombreReceta,likes,nacionalidad,categoria;
        ImageView imagenReceta;
        Button verDetalle;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            nombreReceta = itemView.findViewById(R.id.nombre_item_receta);
            likes = itemView.findViewById(R.id.n_likes);
            imagenReceta = itemView.findViewById(R.id.img_item_receta);
            verDetalle = itemView.findViewById(R.id.ver_detalle_receta);
        }

    }
}
