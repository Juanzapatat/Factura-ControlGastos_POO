package com.example;

import java.util.ArrayList;
import java.util.List;

public class ControlGastos {

    private double saldo;
    private List<Gasto> gastos;

    public ControlGastos(double saldoInicial) {
        this.saldo = saldoInicial;
        this.gastos = new ArrayList<>();
    }

    // Getter y Setter para saldo
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Getter y Setter para gastos
    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    // Permite registrar un gasto si hay suficiente saldo
    public void registrarGasto(String descripcion, double valor, String fecha) {
        if (valor > saldo) {
            System.out.println("Fondos insuficientes.");
        } else {
            Gasto gasto = new Gasto(descripcion, valor, fecha); // Usa constructor actualizado
            gastos.add(gasto);
            saldo -= valor;
            System.out.println("Gasto registrado correctamente.");
        }
    }

    // Añade dinero al saldo
    public void recargarSaldo(double monto) {
        saldo += monto;
        System.out.println("Saldo recargado correctamente.");
    }

    // Muestra todos los gastos registrados y el saldo actual
    public void mostrarGastos() {
        for (Gasto g : gastos) {
            g.mostrar();
        }
        System.out.println("Saldo actual: " + saldo);
    }
}

