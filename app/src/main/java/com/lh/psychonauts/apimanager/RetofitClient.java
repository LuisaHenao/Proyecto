package com.lh.psychonauts.apimanager;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetofitClient {
    private static RetofitClient instance = null;
    private Api myApi;
    private RetofitClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        myApi = retrofit.create(Api.class);
    }

    public static synchronized RetofitClient getInstance(){
        if(instance == null){
            instance = new RetofitClient();
        }

        return instance;
    }

    public Api getMyApi(){
        return myApi;
    }
}


