package com.example.apiwebfinal.Model;

public class Productos {

    private int idProducto;
    private String producto;
    private int idMarca;
    private String descripcion;
    private String precio_costo;
    private String precio_venta;
    private int existencia;
    private String fecha_ingreso;

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public String getPrecio_costo() {
        return precio_costo;
    }

    public String getPrecio_venta() {
        return precio_venta;
    }

    public int getExistencia() {
        return existencia;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }
}
