package com.habib.proyectofinalpsp.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.habib.proyectofinalpsp.Utils.Feed;
import com.julian.proyectofinalpsp.R;
import com.habib.proyectofinalpsp.Utils.Recetas;

import java.util.List;

public class AdaptadorSpinner extends BaseAdapter {
    private List<Feed> listaRecetas;
    private Context context;

    @Override
    public int getCount() {

        return listaRecetas.size();
    }

    @Override
    public Object getItem(int position) {
        return listaRecetas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Feed feed = listaRecetas.get(position);
        convertView= LayoutInflater.from(context).inflate(R.layout.fila_spinner,parent,false);
        TextView textoRecetas=convertView.findViewById(R.id.texto_fila_recetas);
        ImageView imageRecetas=convertView.findViewById(R.id.img_fila_spinner);
        textoRecetas.setText(feed.getFecha());
        Glide.with(context).load(feed.getImagen()).into(imageRecetas);





        return convertView;
    }
    public void rellenarLista(Recetas receta){
        listaRecetas.add(receta);
        notifyDataSetChanged();
    }

    public AdaptadorSpinner(List<Recetas> listaRecetas, Context context) {
        this.listaRecetas = listaRecetas;
        this.context = context;
    }
}
