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

public class list_personajes_female extends AppCompatActivity  implements View.OnClickListener  {

    ListView ListPersonajesFemale;
    List<Personajes> myPersonaje;

    Button btnTodosF;
    Button btnMaleF;
    Button btnFemaleF;
    Button btnInicioF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_personajes_female);

        ListPersonajesFemale = findViewById(R.id.ListPersonajesFemale);
        btnTodosF = findViewById(R.id.btnTodosF);
        btnMaleF = findViewById(R.id.btnMaleF);
        btnFemaleF = findViewById(R.id.btnFemaleF);
        btnInicioF= findViewById(R.id.btnInicioF);

        btnTodosF.setOnClickListener(this);
        btnMaleF.setOnClickListener(this);
        btnFemaleF.setOnClickListener(this);
        btnInicioF.setOnClickListener(this);

        getFromIntenetPersonaje();

    }

    private void getFromIntenetPersonaje(){

        Call<List<Personajes>> call = RetofitClient.getInstance().getMyApi().getPersonajesFemale();
        call.enqueue(new Callback<List<Personajes>>() {


            @Override
            public void onResponse(Call<List<Personajes>> call, Response<List<Personajes>> response) {
                myPersonaje = response.body();
                String message = "";
                PersonajesAdapter adapter = new PersonajesAdapter(list_personajes_female.this, myPersonaje);
                ListPersonajesFemale.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Personajes>> call, Throwable t) {
                Toast.makeText(list_personajes_female.this, "Error!!", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnTodosF){
            Intent Myintent = new Intent(this, List_Personajes.class );
            startActivity(Myintent);
        }

        if (v.getId() == R.id.btnMaleF){
            Intent Myintent = new Intent(this, list_personajes_male.class );
            startActivity(Myintent);
        }

        if (v.getId() == R.id.btnFemaleF){
            Intent Myintent = new Intent(this, list_personajes_female.class );
            startActivity(Myintent);
        }

        if (v.getId() == R.id.btnInicioF){
            Intent Myintent = new Intent(this, MainActivity.class );
            startActivity(Myintent);
        }
    }
}