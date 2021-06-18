package com.lh.psychonauts.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Personajes {

    @SerializedName("name")
    private String Name;

    @SerializedName("gender")
    private String Genero;

    @SerializedName("_id")
    private String Id;

    @SerializedName("img")
    private String ImgPersonaje;

    @SerializedName("psiPowers")
    private List<Poderes> PoderPersonaje;

    public List<Poderes> getPoderPersonaje() {
        return PoderPersonaje;
    }

    public void setPoderPersonaje(List<Poderes> poderPersonaje) {
        PoderPersonaje = poderPersonaje;
    }

    public String getImgPersonaje() {
        return ImgPersonaje;
    }

    public void setImgPersonaje(String imgPersonaje) {
        ImgPersonaje = imgPersonaje;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }



}
