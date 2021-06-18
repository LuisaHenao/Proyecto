package com.lh.psychonauts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnPersonajes;
    private Button btnPoderes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPersonajes = findViewById(R.id.btnPersonajes);
        btnPoderes = findViewById(R.id.btnPoderes);

        btnPersonajes.setOnClickListener(this);
        btnPoderes.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnPersonajes){
            Intent Myintent = new Intent(this, List_Personajes.class );
            startActivity(Myintent);
        }

        if (v.getId() == R.id.btnPoderes){
            Intent Myintent = new Intent(this, list_poder.class );
            startActivity(Myintent);
        }
    }
}