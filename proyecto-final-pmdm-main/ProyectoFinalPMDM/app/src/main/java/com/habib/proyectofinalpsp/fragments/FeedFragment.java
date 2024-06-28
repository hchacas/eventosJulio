package com.habib.proyectofinalpsp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.FirebaseDatabase;
import com.habib.proyectofinalpsp.Adaptadores.AdaptadorFeeds;
import com.habib.proyectofinalpsp.Utils.Feed;
import com.julian.proyectofinalpsp.R;
import com.habib.proyectofinalpsp.Utils.Recetas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class FeedFragment extends Fragment {
    private View view;
    private Recetas receta;

    private Feed fedd;
    private RecyclerView recyclerView;

    private AdaptadorFeeds adaptadorFeeds;

    private AdaptadorFeeds.OnRecetaListener listener;
    private FirebaseDatabase firebaseDatabase;
    private String uid="";



    public static FeedFragment newInstance(Recetas receta, String uid) {

        Bundle args = new Bundle();
        args.putSerializable("receta",receta);
        args.putString("uid",uid);
        FeedFragment recetas = new FeedFragment();
        recetas.setArguments(args);
        return recetas;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getArguments() != null){
            receta = (Recetas) getArguments().getSerializable("receta");
            uid = getArguments().getString("uid");


        }

        try {
            listener = (AdaptadorFeeds.OnRecetaListener) context;
        } catch (Exception e) {
            Log.v("Error", "La comunicacion no ha podido llevarse a cabo");
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        instancias();
        asociarDatos();
        realizarPeticion();

    }
    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_recetas, container, false);

        return view;
    }

    private void realizarPeticion() {

        String url = "https://themealdb.com/api/json/v1/1/search.php?s";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(1, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                procesarPeticion(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(getContext()).add(jsonObjectRequest);


        //adaptadorEquipos.notifyDataSetChanged();
    }

    private void procesarPeticion(JSONObject response) {

        try {
            JSONArray recetas = response.getJSONArray("meals");
            for (int i = 0; i < 15; i++) {
                String fecha = "1/05/204";
                String[] comentarios = {"Comentario 1", "Comentario 2", "Comentario 3"};
                int likes = 5;
                String imagen = "https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg";

                Feed feedActual = new Feed(fecha, comentarios, likes, imagen);
                adaptadorFeeds.agregarReceta(feedActual);


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void asociarDatos() {
        recyclerView.setAdapter(adaptadorFeeds);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,RecyclerView.VERTICAL));
    }

    private void instancias() {
        recyclerView = view.findViewById(R.id.lista_recetas);
        adaptadorFeeds = new AdaptadorFeeds(getContext());
    }






}
