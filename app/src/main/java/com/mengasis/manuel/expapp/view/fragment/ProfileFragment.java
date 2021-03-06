package com.mengasis.manuel.expapp.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mengasis.manuel.expapp.R;
import com.mengasis.manuel.expapp.adapter.PictureAdapterRecyclerView;
import com.mengasis.manuel.expapp.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        showToolbar("", false, view);

        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureProfileRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        //Es para que el scroll sea vertical
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buidPictures(), R.layout.cardview_picture, getActivity());

        picturesRecycler.setAdapter(pictureAdapterRecyclerView);


        return view;
    }

    // Recibira un titulo y un boton de regreso
    public void showToolbar(String titulo, Boolean upButton ,View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbarProfile);

        //Se obtiene el activity en el que esta contenido el fragment y se castea para que sea AppCompactActivity
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo);

        // Activa o desactiva el boton de regreso
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    public ArrayList<Picture> buidPictures(){
        ArrayList<Picture> pictures = new ArrayList<Picture>();
        pictures.add(new Picture("Bruce Wayne", "https://i.kinja-img.com/gawker-media/image/upload/s--WEKTrINQ--/c_fit,fl_progressive,q_80,w_636/suaimrstjyxxunpmrfqr.jpg", "100 dias", "100"));
        pictures.add(new Picture("Dick Grayson", "http://dualpixels.com/wp-content/uploads/2015/06/news_illustre_1365000389_224-e1434075039752.jpg", "60 dias", "80"));
        pictures.add(new Picture("Jason Todd", "http://static.srcdn.com/wp-content/uploads/redhood-2-dcrebirth.jpg", "55 dias", "75"));
        pictures.add(new Picture("Tim Drake", "https://i.ytimg.com/vi/Jhp4ygmsO_k/maxresdefault.jpg", "40 dias", "70"));
        pictures.add(new Picture("Damian Wayne", "http://media.dcentertainment.com/sites/default/files/GalleryChar_1900x900_DamianWayne_52ab7536d3f7a0.28359128.jpg", "10 dias", "40"));

        return pictures;
    }

}
