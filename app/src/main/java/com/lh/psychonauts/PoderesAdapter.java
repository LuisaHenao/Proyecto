package com.lh.psychonauts;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lh.psychonauts.models.Personajes;
import com.lh.psychonauts.models.Poderes;

import java.util.List;

public class PoderesAdapter extends BaseAdapter {
    protected Activity activity;
    protected List<Poderes> myPoderes;

    public PoderesAdapter(Activity activity, List<Poderes> myPoderes) {
        this.activity = activity;
        this.myPoderes = myPoderes;
    }

    @Override
    public int getCount() {
        return  myPoderes.size();
    }

    @Override
    public Object getItem(int position) {
        return myPoderes.get(position);
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
            v = inf.inflate(R.layout.activity_item_poder,null);
        }

        Poderes poder = myPoderes.get(position);
        TextView txtPoder = v.findViewById(R.id.txtPoder);
        TextView txtDescrip = v.findViewById(R.id.txtDescrip);
        ImageView imgPoder = v.findViewById(R.id.imgPoder);
        txtPoder.setText(poder.getNombrePoder());
        txtDescrip.setText(poder.getDescripcion());
        Glide.with(activity)
                .load(poder.getImgPoder())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgPoder);


        return v;
    }
}
