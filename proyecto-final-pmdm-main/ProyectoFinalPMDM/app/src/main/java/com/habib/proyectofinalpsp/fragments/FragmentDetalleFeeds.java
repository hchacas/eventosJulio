package com.habib.proyectofinalpsp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.habib.proyectofinalpsp.Utils.Feed;
import com.habib.proyectofinalpsp.Utils.Recetas;
import com.julian.proyectofinalpsp.R;


public class FragmentDetalleFeeds extends Fragment  {

    private View view;
    private ImageView imagen;
    private TextView nombre,categoria,descripcion,nacionalidad;
    private Recetas recetaaRecuperda;


    public static FragmentDetalleFeeds newInstance(Feed feed, String uid){
        Bundle args =new Bundle();
        args.putSerializable("feed",feed);
        args.putSerializable("uid",uid);
        FragmentDetalleFeeds fragment = new FragmentDetalleFeeds();
        fragment.setArguments(args);
        return fragment;


    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);




    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_detalle_recetas,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        instancias();
        iniciarVista();
    }

    private void iniciarVista() {
        nombre.setText(recetaaRecuperda.getNombre());
        descripcion.setText(recetaaRecuperda.getDescripcion());
        nacionalidad.setText(recetaaRecuperda.getNacionalidad());
        categoria.setText(recetaaRecuperda.getCategoria());
        Glide.with(getContext()).load(recetaaRecuperda.getImagen()).into(imagen);


    }

    private void instancias() {
        imagen=view.findViewById(R.id.imagen_detalle_recetas);
        nombre=view.findViewById(R.id.nombre_detalle_recetas);
        descripcion=view.findViewById(R.id.descipcion_detalle_recetas);
        categoria=view.findViewById(R.id.categoria_detalle_recetas);
        nacionalidad=view.findViewById(R.id.nacionalidad_detalle_recetas);

    }

}
