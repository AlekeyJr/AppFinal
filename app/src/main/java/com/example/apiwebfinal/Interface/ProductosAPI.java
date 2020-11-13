package com.example.apiwebfinal.Interface;

import com.example.apiwebfinal.Model.Productos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductosAPI {

    @GET("api/Productos")
    Call<List<Productos>> getProductos();
}
