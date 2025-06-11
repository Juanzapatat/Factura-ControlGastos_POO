package com.example;

public class Gasto {
    private int id;
    private String descripcion;
    private double valor;
    private String fecha;

    public Gasto(String descripcion, double valor, String fecha) {
        this.descripcion = descripcion;
        this.valor = valor;
        this.fecha = fecha;
    }

    public int getId() 
    { return id; }
    public void setId(int id)
     { this.id = id; }

    // getters y setters de descripción, valor y fecha...

    public void mostrar(){
        System.out.println("Gasto: " + descripcion + ", Valor: " + valor + ", Fecha: " + fecha);
    }
}
