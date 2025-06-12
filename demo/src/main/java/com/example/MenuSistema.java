package com.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MenuSistema {
    private Scanner sc = new Scanner(System.in);
    private Usuario usuario = new Usuario("CESDE", "1230"); // Usuario predeterminado
    private List<Factura> facturas = new ArrayList<>(); // Lista persistente de facturas

    public void iniciar() {
        if (login()) {
            mostrarMenu();
        }
    }

    // Solicita credenciales hasta que sean correctas
    private boolean login() {
        while (true) {
            System.out.print("Ingrese usuario: ");
            String u = sc.nextLine();

            System.out.print("Ingrese contraseña: ");
            String p = sc.nextLine();

            if (usuario.autenticar(u, p)) {
                System.out.println("Bienvenido al sistema.");
                return true;
            } else {
                System.out.println("Credenciales incorrectas. Intente nuevamente.");
            }
        }
    }

    // Muestra menú principal con opciones
    private void mostrarMenu() {
        while (true) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registro de Facturas");
            System.out.println("2. Control de Gastos");
            System.out.println("3. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    menuFacturas();
                    break;
                case 2:
                    menuControlGastos();
                    break;
                case 3:
                    System.out.println("Gracias por usar el sistema.");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // Submenú para registrar y ver facturas
    private void menuFacturas() {
        while (true) {
            System.out.println("\n--- MENÚ FACTURAS ---");
            System.out.println("1. Registrar nueva factura");
            System.out.println("2. Ver facturas registradas");
            System.out.println("3. Volver al menú principal");

            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    // Solicita datos de la factura
                    System.out.print("Descripción: ");
                    String descripcion = sc.nextLine();

                    System.out.print("Valor de la factura: ");
                    double valor = Double.parseDouble(sc.nextLine());

                    System.out.print("¿Agregar IVA del 19%? (si/no): ");
                    boolean conIVA = sc.nextLine().equalsIgnoreCase("si");

                    System.out.print("Fecha (dd/mm/aaaa): ");
                    String fecha = sc.nextLine();

                    System.out.print("Consumidor final: ");
                    String consumidor = sc.nextLine();

                    // Generar ID único
                    int ID = facturas.size() + 1;

                    // Crea la factura y la guarda
                    Factura factura = new Factura(descripcion, valor, conIVA, fecha, consumidor, ID);
                    facturas.add(factura);

                    System.out.println("Factura registrada correctamente.");
                    break;

                case 2:
                    // Muestra todas las facturas registradas
                    if (facturas.isEmpty()) {
                        System.out.println("No hay facturas registradas.");
                    } else {
                        for (Factura f : facturas) {
                            f.mostrar();
                            System.out.println();
                        }
                    }
                    break;

                case 3:
                    // Vuelve al menú principal
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // Submenú para controlar gastos y saldo
   private void menuControlGastos() {
    System.out.print("Ingrese el saldo inicial: ");
    double saldoInicial = Double.parseDouble(sc.nextLine());

    ControlGastos control = new ControlGastos(saldoInicial);

    while (true) {
        System.out.println("\n--- MENÚ GASTOS ---");
        System.out.println("1. Registrar gasto");
        System.out.println("2. Recargar saldo");
        System.out.println("3. Ver gastos y saldo");
        System.out.println("4. Volver al menú principal");

        int opcion = Integer.parseInt(sc.nextLine());

        switch (opcion) {
            case 1:
                // Solicitar descripción del gasto
                System.out.print("Descripción del gasto: ");
                String descripcion = sc.nextLine();

                // Solicitar valor del gasto
                System.out.print("Valor del gasto: ");
                double valor = Double.parseDouble(sc.nextLine());

                // Solicitar fecha del gasto
                System.out.print("Fecha del gasto (dd/mm/aaaa): ");
                String fecha = sc.nextLine(); // Solicitar fecha para el gasto

                // Generar un ID único para el gasto
                int idGasto = control.getGastos().size() + 1;

                // Crear el objeto Gasto con el ID generado
                Gasto gasto = new Gasto(idGasto, descripcion, valor, fecha);

                // Registrar el gasto
                control.registrarGasto(gasto);
                break;

            case 2:
                // Solicitar monto a recargar
                System.out.print("Monto a recargar: ");
                double recarga = Double.parseDouble(sc.nextLine());
                control.recargarSaldo(recarga);
                break;

            case 3:
                control.mostrarGastos();
                break;

            case 4:
                return;

            default:
                System.out.println("Opción inválida.");
        }
    }
}
}
