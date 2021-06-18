package com.lh.psychonauts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.lh.psychonauts.apimanager.RetofitClient;
import com.lh.psychonauts.models.Personajes;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class list_personajes_male extends AppCompatActivity implements View.OnClickListener{
    ListView list_male;
    List<Personajes> myPersonaje;
    Button btnTodosMale;
    Button btnMaleMale;
    Button btnFamaleMale;
    Button btnInicioM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_personajes_male);

        list_male = findViewById(R.id.list_male);

        btnTodosMale = findViewById(R.id.btnTodosMale);
        btnMaleMale = findViewById(R.id.btnMaleMale);
        btnFamaleMale = findViewById(R.id.btnFamaleMale);
        btnInicioM= findViewById(R.id.btnInicioM);


        btnTodosMale.setOnClickListener(this);
        btnMaleMale.setOnClickListener(this);
        btnFamaleMale.setOnClickListener(this);
        btnInicioM.setOnClickListener(this);

        getFromIntenetPersonajeMale();
    }

    private void getFromIntenetPersonajeMale(){


        Call<List<Personajes>> call = RetofitClient.getInstance().getMyApi().getPersonajesMale();
        call.enqueue(new Callback<List<Personajes>>() {


            @Override
            public void onResponse(Call<List<Personajes>> call, Response<List<Personajes>> response) {
                myPersonaje = response.body();
                String message = "";
                PersonajesAdapter adapter = new PersonajesAdapter(list_personajes_male.this, myPersonaje);
                list_male.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Personajes>> call, Throwable t) {
                Toast.makeText(list_personajes_male.this, "Error!!", Toast.LENGTH_SHORT).show();
            }
        });




    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnTodosMale){
            Intent Myintent = new Intent(this, List_Personajes.class );
            startActivity(Myintent);
        }

        if (v.getId() == R.id.btnMaleMale){
            Intent Myintent = new Intent(this, list_personajes_male.class );
            startActivity(Myintent);
        }

        if (v.getId() == R.id.btnFamaleMale){
            Intent Myintent = new Intent(this, list_personajes_female.class );
            startActivity(Myintent);
        }

        if (v.getId() == R.id.btnInicioM){
            Intent Myintent = new Intent(this, MainActivity.class );
            startActivity(Myintent);
        }
    }
}