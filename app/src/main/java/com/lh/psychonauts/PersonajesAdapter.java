package com.lh.psychonauts;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lh.psychonauts.models.Personajes;

import java.util.List;

public class PersonajesAdapter  extends BaseAdapter {
    protected Activity activity;
    protected List<Personajes> myPersonajes;

    public PersonajesAdapter(Activity activity, List<Personajes> myPersonajes) {
        this.activity = activity;
        this.myPersonajes = myPersonajes;
    }


    @Override
    public int getCount() {
        return  myPersonajes.size();
    }

    @Override
    public Object getItem(int position) {
        return myPersonajes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.activity_item_personaje,null);
        }

        Personajes personaje = myPersonajes.get(position);
        TextView txtName = v.findViewById(R.id.txtName);
        TextView txtGenero = v.findViewById(R.id.txtGenero);
        ImageView imgPersonaje = v.findViewById(R.id.imgPersonaje);
        txtName.setText(personaje.getName());
        txtGenero.setText(personaje.getGenero());
        Glide.with(activity)
                .load(personaje.getImgPersonaje())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgPersonaje);

        return v;
    }
}
