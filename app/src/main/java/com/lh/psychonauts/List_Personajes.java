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
import retrofit2.Retrofit;

public class List_Personajes extends AppCompatActivity implements View.OnClickListener {

    ListView ListPersonajes;
    List<Personajes> myPersonaje;

    Button btnTodos;
    Button btnMale;
    Button btnFemale;
    Button btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__personajes);

        ListPersonajes = findViewById(R.id.ListPersonajes);
        btnTodos = findViewById(R.id.btnTodos);
        btnMale = findViewById(R.id.btnMale);
        btnFemale = findViewById(R.id.btnFemale);
        btnInicio= findViewById(R.id.btnInicio);

        btnTodos.setOnClickListener(this);
        btnMale.setOnClickListener(this);
        btnFemale.setOnClickListener(this);
        btnInicio.setOnClickListener(this);

        getFromIntenetPersonaje();

    }

    private void getFromIntenetPersonaje(){

            Call<List<Personajes>> call = RetofitClient.getInstance().getMyApi().getPersonajes();
            call.enqueue(new Callback<List<Personajes>>() {


                @Override
                public void onResponse(Call<List<Personajes>> call, Response<List<Personajes>> response) {
                    myPersonaje = response.body();
                    String message = "";
                    PersonajesAdapter adapter = new PersonajesAdapter(List_Personajes.this, myPersonaje);
                    ListPersonajes.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<List<Personajes>> call, Throwable t) {
                    Toast.makeText(List_Personajes.this, "Error!!", Toast.LENGTH_SHORT).show();
                }
            });

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnTodos){
            Intent Myintent = new Intent(this, List_Personajes.class );
            startActivity(Myintent);
        }

        if (v.getId() == R.id.btnMale){
            Intent Myintent = new Intent(this, list_personajes_male.class );
            startActivity(Myintent);
        }

        if (v.getId() == R.id.btnFemale){
            Intent Myintent = new Intent(this, list_personajes_female.class );
            startActivity(Myintent);
        }

        if (v.getId() == R.id.btnInicio){
            Intent Myintent = new Intent(this, MainActivity.class );
            startActivity(Myintent);
        }
    }
}