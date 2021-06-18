package com.lh.psychonauts;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lh.psychonauts.apimanager.RetofitClient;
import com.lh.psychonauts.models.Personajes;
import com.lh.psychonauts.models.Poderes;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class list_poder extends AppCompatActivity {

    ListView listPoderes;
    List<Poderes> myPoder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_poder);

        listPoderes = findViewById(R.id.listPoderes);

        getFromIntenetPoder();
    }
    private void getFromIntenetPoder(){
        Call<List<Poderes>> call = RetofitClient.getInstance().getMyApi().getPoderes();
        call.enqueue(new Callback<List<Poderes>>() {
            @Override
            public void onResponse(Call<List<Poderes>> call, Response<List<Poderes>> response) {
                myPoder = response.body();
                String message = "";
                PoderesAdapter  adapter = new PoderesAdapter(list_poder.this, myPoder);
                listPoderes.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Poderes>> call, Throwable t) {
                Toast.makeText(list_poder.this, "Error!!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}