package com.example.apiwebfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.apiwebfinal.Interface.ProductosAPI;
import com.example.apiwebfinal.Model.Productos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView TextProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            TextProducto = findViewById(R.id.TextoProducto);

            getProductos();

            //icono actionbar

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

   private void getProductos(){

       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl("https://apiwebfinal.azurewebsites.net/")
               .addConverterFactory(GsonConverterFactory.create())
               .build();

       ProductosAPI productosAPI = retrofit.create(ProductosAPI.class);
       Call<List<Productos>> call = productosAPI.getProductos();
       call.enqueue(new Callback<List<Productos>>() {
           @Override
           public void onResponse(Call<List<Productos>> call, Response<List<Productos>> response) {

               if(!response.isSuccessful()){
                 TextProducto.setText("Codigo: "+response.code());
                 return;
               }

               List<Productos> productosList = response.body();

               for(Productos productos: productosList){
                   String contents = "";
                   contents += "idProducto: "+ productos.getIdProducto()+"\n";
                   contents += "producto: "+ productos.getProducto()+"\n";
                   contents += "idMarca: "+ productos.getIdMarca()+"\n";
                   contents += "descripcion: "+ productos.getDescripcion()+"\n";
                   contents += "precio_costo: Q"+ productos.getPrecio_costo()+"\n";
                   contents += "precio_venta: Q"+ productos.getPrecio_venta()+"\n";
                   contents += "existencia: "+ productos.getExistencia()+"\n";
                   contents += "fecha_ingreso: "+ productos.getFecha_ingreso()+"\n" +
                           "------------------------\n";

                   TextProducto.append(contents);

               }
           }

           @Override
           public void onFailure(Call<List<Productos>> call, Throwable t) {
                TextProducto.setText(t.getMessage());
           }
       });

   }

}