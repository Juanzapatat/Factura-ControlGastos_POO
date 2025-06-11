// package com.example;

// import java.util.List;
// import java.util.Scanner;

// import com.example.DAO.FacturaDAO;
// import com.example.DAO.GastoDAO;

// public class MenuSistema {
//     private Scanner sc = new Scanner(System.in);
//     private Usuario usuario = new Usuario("CESDE", "1230");

//     private FacturaDAO facturaDAO = new FacturaDAO();
//     private GastoDAO gastoDAO = new GastoDAO();

//     private double saldo = 0;

//     public void iniciar() {
//         if (login()) {
//             mostrarMenu();
//         }
//     }

//     private boolean login() {
//         while (true) {
//             System.out.print("Ingrese usuario: ");
//             String u = sc.nextLine();

//             System.out.print("Ingrese contraseña: ");
//             String p = sc.nextLine();

//             if (usuario.autenticar(u, p)) {
//                 System.out.println("✅ Bienvenido al sistema.");
//                 return true;
//             } else {
//                 System.out.println("❌ Credenciales incorrectas. Intente nuevamente.");
//             }
//         }
//     }

//     private void mostrarMenu() {
//         while (true) {
//             System.out.println("\n--- MENÚ PRINCIPAL ---");
//             System.out.println("1. CRUD Facturas");
//             System.out.println("2. CRUD Gastos");
//             System.out.println("3. Salir");

//             System.out.print("Seleccione una opción: ");
//             int opcion = Integer.parseInt(sc.nextLine());

//             switch (opcion) {
//                 case 1 -> menuFacturas();
//                 case 2 -> menuGastos();
//                 case 3 -> {
//                     System.out.println("👋 Gracias por usar el sistema.");
//                     return;
//                 }
//                 default -> System.out.println("⚠️ Opción inválida.");
//             }
//         }
//     }

//     private void menuFacturas() {
//         while (true) {
//             System.out.println("\n--- CRUD FACTURAS ---");
//             System.out.println("1. Registrar nueva factura");
//             System.out.println("2. Ver facturas");
//             System.out.println("3. Actualizar factura");
//             System.out.println("4. Eliminar factura");
//             System.out.println("5. Volver");

//             System.out.print("Seleccione una opción: ");
//             int opcion = Integer.parseInt(sc.nextLine());

//             switch (opcion) {
//                 case 1 -> {
//                     System.out.print("Descripción: ");
//                     String descripcion = sc.nextLine();

//                     System.out.print("Valor: ");
//                     double valor = Double.parseDouble(sc.nextLine());

//                     System.out.print("¿Agregar IVA del 19%? (si/no): ");
//                     boolean conIVA = sc.nextLine().equalsIgnoreCase("si");

//                     System.out.print("Fecha (dd/mm/aaaa): ");
//                     String fecha = sc.nextLine();

//                     System.out.print("Consumidor final: ");
//                     String consumidor = sc.nextLine();

//                     Factura f = new Factura(descripcion, valor, conIVA, fecha, consumidor, null);
//                     facturaDAO.insertar(f);
//                 }

//                 case 2 -> {
//                     List<Factura> facturas = facturaDAO.listar();
//                     for (Factura f : facturas) {
//                         f.mostrar();
//                         System.out.println();
//                     }
//                 }

//                 case 3 -> {
//                     System.out.print("ID de la factura a actualizar: ");
//                     int id = Integer.parseInt(sc.nextLine());

//                     System.out.print("Nueva descripción: ");
//                     String descripcion = sc.nextLine();

//                     System.out.print("Nuevo valor: ");
//                     double valor = Double.parseDouble(sc.nextLine());

//                     System.out.print("¿Agregar IVA del 19%? (si/no): ");
//                     boolean conIVA = sc.nextLine().equalsIgnoreCase("si");

//                     System.out.print("Nueva fecha (dd/mm/aaaa): ");
//                     String fecha = sc.nextLine();

//                     System.out.print("Nuevo consumidor final: ");
//                     String consumidor = sc.nextLine();

//                     Factura f = new Factura(descripcion, valor, conIVA, fecha, consumidor, id);
//                     f.setID(id);
//                     facturaDAO.actualizar(f);
//                 }

//                 case 4 -> {
//                     System.out.print("ID de la factura a eliminar: ");
//                     int id = Integer.parseInt(sc.nextLine());
//                     facturaDAO.eliminar(id);
//                 }

//                 case 5 -> {
//                     return;
//                 }

//                 default -> System.out.println("⚠️ Opción inválida.");
//             }
//         }
//     }

//     private void menuGastos() {
//         while (true) {
//             System.out.println("\n--- CRUD GASTOS ---");
//             System.out.println("1. Registrar gasto");
//             System.out.println("2. Ver gastos");
//             System.out.println("3. Actualizar gasto");
//             System.out.println("4. Eliminar gasto");
//             System.out.println("5. Recargar saldo");
//             System.out.println("6. Ver saldo actual");
//             System.out.println("7. Volver");

//             System.out.print("Seleccione una opción: ");
//             int opcion = Integer.parseInt(sc.nextLine());

//             switch (opcion) {
//                 case 1 -> {
//                     System.out.print("Descripción: ");
//                     String descripcion = sc.nextLine();

//                     System.out.print("Valor: ");
//                     double valor = Double.parseDouble(sc.nextLine());

//                     if (valor > saldo) {
//                         System.out.println("❌ Fondos insuficientes.");
//                     } else {
//                         System.out.print("Fecha (dd/mm/aaaa): ");
//                         String fecha = sc.nextLine();

//                         Gasto g = new Gasto(descripcion, valor, fecha);
//                         gastoDAO.insertar(g);
//                         saldo -= valor;
//                     }
//                 }

//                 case 2 -> {
//                     List<Gasto> lista = gastoDAO.listar();
//                     for (Gasto g : lista) {
//                         g.mostrar();
//                         System.out.println();
//                     }
//                 }

//                 case 3 -> {
//                     System.out.print("ID del gasto a actualizar: ");
//                     int id = Integer.parseInt(sc.nextLine());

//                     System.out.print("Nueva descripción: ");
//                     String descripcion = sc.nextLine();

//                     System.out.print("Nuevo valor: ");
//                     double valor = Double.parseDouble(sc.nextLine());

//                     System.out.print("Nueva fecha (dd/mm/aaaa): ");
//                     String fecha = sc.nextLine();

//                     Gasto g = new Gasto(descripcion, valor, fecha);
//                     g.setId(id);
//                     gastoDAO.actualizar(g);
//                 }

//                 case 4 -> {
//                     System.out.print("ID del gasto a eliminar: ");
//                     int id = Integer.parseInt(sc.nextLine());
//                     gastoDAO.eliminar(id);
//                 }

//                 case 5 -> {
//                     System.out.print("Monto a recargar: ");
//                     double recarga = Double.parseDouble(sc.nextLine());
//                     saldo += recarga;
//                     System.out.println("💰 Saldo recargado.");
//                 }

//                 case 6 -> System.out.println("Saldo actual: " + saldo);

//                 case 7 -> {
//                     return;
//                 }

//                 default -> System.out.println("⚠️ Opción inválida.");
//             }
//         }
//     }
// }
