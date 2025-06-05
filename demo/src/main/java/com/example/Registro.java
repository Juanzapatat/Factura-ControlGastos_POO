//BASE PARA REGISTRO FACTURA Y GASTOS.

package com.example;

public abstract class Registro {
    
    // ATRIBUTOS PRIVADOS DE LA CLASE
private String descripcion;
private double valor;

//CONSTRUCTOR
public Registro(String descripcion, double valor ){

this.descripcion=descripcion;
this.valor=valor;
}
// Getter para descripcion
public String getDescripcion() {
    return descripcion;
}

// Setter para descripcion
public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}

// Getter para valor
public double getValor() {
    return valor;
}

// Setter para valor
public void setValor(double valor) {
    this.valor = valor;
}
     

// METODO ABSTRACTO QUE OBLIGA A MOSTARR LOS DATOS DEL REGISTRO
public abstract void mostrar();






}
