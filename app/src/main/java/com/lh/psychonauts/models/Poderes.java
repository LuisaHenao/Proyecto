package com.lh.psychonauts.models;

import com.google.gson.annotations.SerializedName;

public class Poderes {

    @SerializedName("description")
    private String Descripcion;

    @SerializedName("img")
    private String ImgPoder;

    @SerializedName("name")
    private String NombrePoder;

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getImgPoder() {
        return ImgPoder;
    }

    public void setImgPoder(String imgPoder) {
        ImgPoder = imgPoder;
    }

    public String getNombrePoder() {
        return NombrePoder;
    }

    public void setNombrePoder(String nombrePoder) {
        NombrePoder = nombrePoder;
    }


}
