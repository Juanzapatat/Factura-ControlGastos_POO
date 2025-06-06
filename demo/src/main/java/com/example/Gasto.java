package com.example;

    /**
 * Representa un gasto simple con descripción y valor.
 */
public class Gasto extends Registro {
    public Gasto(String descripcion, double valor) {
        super(descripcion, valor);
    }

    @Override
    public void mostrar() {
        System.out.println("----- GASTO -----");
        System.out.println("Descripción: " + getDescripcion());
        System.out.println("Valor: " + getValor());
    }
}
    

