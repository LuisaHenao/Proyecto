package com.lh.psychonauts.apimanager;

import retrofit2.Call;
import com.lh.psychonauts.models.Personajes;
import com.lh.psychonauts.models.Poderes;

import java.util.List;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://psychonauts-api.herokuapp.com/api/";

    @GET("characters")
    Call<List<Personajes>> getPersonajes();

    @GET("characters?gender=female")
    Call<List<Personajes>> getPersonajesFemale();

    @GET("characters?gender=male")
    Call<List<Personajes>> getPersonajesMale();

    @GET("powers")
    Call<List<Poderes>> getPoderes();

}
