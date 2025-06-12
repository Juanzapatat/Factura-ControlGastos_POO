package com.example;

import java.util.Date;

public class Gasto {
    private Integer ID;
    private String descripcion;
    private double valor;
    private String fecha;

    public Gasto(Integer ID, String descripcion, double valor, String fecha) {
        this.descripcion = descripcion;
        this.valor = valor;
        this.fecha = fecha;
    }

    public Integer getID(){
        return ID;
    }
    public void setId(Integer ID){
        this.ID=ID;
    }


 public String getDescripcion() {
    return descripcion;
}

public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}

public double getValor() {
    return valor;
}

public void setValor(double valor) {
    this.valor = valor;
}

public String getFecha() {
    return fecha;
}

public void setFecha(String fecha) {
    this.fecha = fecha;
}

    public void mostrar(){
        System.out.println("Gasto: " + descripcion + ", Valor: " + valor + ", Fecha: " + fecha);
    }
}
