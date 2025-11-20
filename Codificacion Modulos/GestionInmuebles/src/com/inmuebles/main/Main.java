package com.inmuebles.main;

import com.inmuebles.dao.*;
import com.inmuebles.modelo.*;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("====================================");
            System.out.println("       SISTEMA DE INMUEBLES");
            System.out.println("====================================");
            System.out.println("1. Gestionar Usuarios");
            System.out.println("2. Gestionar Clientes");
            System.out.println("3. Gestionar Propietarios");
            System.out.println("4. Gestionar Inmobiliarias");
            System.out.println("5. Gestionar Propiedades");
            System.out.println("6. Gestionar Publicaciones");
            System.out.println("7. Gestionar Historial de Publicaciones");
            System.out.println("8. Gestionar Compras");
            System.out.println("9. Gestionar Contratos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> menuUsuario();
                case 2 -> menuCliente();
                case 3 -> menuPropietario();
                case 4 -> menuInmobiliaria();
                case 5 -> menuPropiedad();
                case 6 -> menuPublicacion();
                case 7 -> menuHistorial();
                case 8 -> menuCompra();
                case 9 -> menuContrato();
                case 0 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    // ================================
    //   MENU USUARIO
    // ================================
    private static void menuUsuario() {
        UsuarioDAO dao = new UsuarioDAO();
        System.out.println("------ USUARIOS ------");
        System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Buscar por ID");
        System.out.println("4. Actualizar");
        System.out.println("5. Eliminar");
        System.out.print("Opción: ");
        int op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Correo: ");
                String c = sc.nextLine();
                System.out.print("Contraseña: ");
                String pass = sc.nextLine();
                System.out.print("Tipo (Administrador/Cliente/Propietario/Inmobiliaria): ");
                String tipo = sc.nextLine();

                dao.insertar(new Usuario(0, c, pass, tipo));
            }

            case 2 -> {
                List<Usuario> lista = dao.listar();
                lista.forEach(System.out::println);
            }

            case 3 -> {
                System.out.print("ID: ");
                int id = sc.nextInt();
                System.out.println(dao.buscarPorId(id));
            }

            case 4 -> {
                System.out.print("ID a actualizar: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("Nuevo correo: ");
                String c = sc.nextLine();
                System.out.print("Nueva contraseña: ");
                String pass = sc.nextLine();
                System.out.print("Nuevo tipo: ");
                String tipo = sc.nextLine();

                dao.actualizar(new Usuario(id, c, pass, tipo));
            }

            case 5 -> {
                System.out.print("ID a eliminar: ");
                int id = sc.nextInt();
                dao.eliminar(id);
            }
        }
    }

    // ================================
    //   MENU CLIENTE
    // ================================
    private static void menuCliente() {
        ClienteDAO dao = new ClienteDAO();
        System.out.println("------ CLIENTES ------");
        System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Buscar por ID");
        System.out.println("4. Actualizar");
        System.out.println("5. Eliminar");
        System.out.print("Opción: ");
        int op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Nombre: ");
                String n = sc.nextLine();
                System.out.print("Correo: ");
                String c = sc.nextLine();
                System.out.print("Teléfono: ");
                String t = sc.nextLine();
                System.out.print("ID de Usuario: ");
                int idu = sc.nextInt();

                dao.insertar(new Cliente(0, n, c, t, idu));
            }

            case 2 -> dao.listar().forEach(System.out::println);

            case 3 -> {
                System.out.print("ID: ");
                int id = sc.nextInt();
                System.out.println(dao.buscarPorId(id));
            }

            case 4 -> {
                System.out.print("ID a actualizar: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("Nuevo nombre: ");
                String n = sc.nextLine();
                System.out.print("Nuevo correo: ");
                String c = sc.nextLine();
                System.out.print("Nuevo teléfono: ");
                String t = sc.nextLine();
                System.out.print("Nuevo ID usuario: ");
                int idu = sc.nextInt();

                dao.actualizar(new Cliente(id, n, c, t, idu));
            }

            case 5 -> {
                System.out.print("ID a eliminar: ");
                int id = sc.nextInt();
                dao.eliminar(id);
            }
        }
    }

    // ================================
    //   MENU PROPIETARIO
    // ================================
    private static void menuPropietario() {
        PropietarioDAO dao = new PropietarioDAO();
        System.out.println("------ PROPIETARIOS ------");
        System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Buscar por ID");
        System.out.println("4. Actualizar");
        System.out.println("5. Eliminar");
        System.out.print("Opción: ");
        int op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Nombre: ");
                String n = sc.nextLine();
                System.out.print("Teléfono: ");
                String t = sc.nextLine();
                System.out.print("Correo: ");
                String c = sc.nextLine();
                System.out.print("ID Usuario: ");
                int idu = sc.nextInt();

                dao.insertar(new Propietario(0, n, t, c, idu));
            }
            case 2 -> dao.listar().forEach(System.out::println);
            case 3 -> {
                System.out.print("ID: ");
                int id = sc.nextInt();
                System.out.println(dao.buscarPorId(id));
            }
            case 4 -> {
                System.out.print("ID a actualizar: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("Nuevo nombre: ");
                String n = sc.nextLine();
                System.out.print("Nuevo teléfono: ");
                String t = sc.nextLine();
                System.out.print("Nuevo correo: ");
                String c = sc.nextLine();
                System.out.print("Nuevo ID usuario: ");
                int idu = sc.nextInt();

                dao.actualizar(new Propietario(id, n, t, c, idu));
            }
            case 5 -> {
                System.out.print("ID a eliminar: ");
                int id = sc.nextInt();
                dao.eliminar(id);
            }
        }
    }

    // ================================
    //   MENU INMOBILIARIA
    // ================================
    private static void menuInmobiliaria() {
        InmobiliariaDAO dao = new InmobiliariaDAO();
        System.out.println("------ INMOBILIARIAS ------");
        System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Buscar por ID");
        System.out.println("4. Actualizar");
        System.out.println("5. Eliminar");
        System.out.print("Opción: ");
        int op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Nombre: ");
                String n = sc.nextLine();
                System.out.print("Dirección: ");
                String d = sc.nextLine();
                System.out.print("Teléfono: ");
                String t = sc.nextLine();
                System.out.print("ID Usuario: ");
                int idu = sc.nextInt();

                dao.insertar(new Inmobiliaria(0, n, d, t, idu));
            }
            case 2 -> dao.listar().forEach(System.out::println);
            case 3 -> {
                System.out.print("ID: ");
                int id = sc.nextInt();
                System.out.println(dao.buscarPorId(id));
            }
            case 4 -> {
                System.out.print("ID a actualizar: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("Nuevo nombre: ");
                String n = sc.nextLine();
                System.out.print("Nueva dirección: ");
                String d = sc.nextLine();
                System.out.print("Nuevo teléfono: ");
                String t = sc.nextLine();
                System.out.print("Nuevo ID usuario: ");
                int idu = sc.nextInt();

                dao.actualizar(new Inmobiliaria(id, n, d, t, idu));
            }
            case 5 -> {
                System.out.print("ID a eliminar: ");
                int id = sc.nextInt();
                dao.eliminar(id);
            }
        }
    }

    // ================================
    //   MENU PROPIEDAD
    // ================================
    private static void menuPropiedad() {
        PropiedadDAO dao = new PropiedadDAO();
        System.out.println("------ PROPIEDADES ------");
        System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Buscar por ID");
        System.out.println("4. Actualizar");
        System.out.println("5. Eliminar");
        System.out.print("Opción: ");
        int op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Tipo: ");
                String tipo = sc.nextLine();
                System.out.print("Ubicación: ");
                String u = sc.nextLine();
                System.out.print("Precio: ");
                double p = sc.nextDouble();
                System.out.print("Habitaciones: ");
                int h = sc.nextInt();
                System.out.print("ID Propietario: ");
                int idp = sc.nextInt();
                System.out.print("ID Inmobiliaria: ");
                int idi = sc.nextInt();

                dao.insertar(new Propiedad(0, tipo, u, p, h, idp, idi));
            }
            case 2 -> dao.listar().forEach(System.out::println);
            case 3 -> {
                System.out.print("ID: ");
                int id = sc.nextInt();
                System.out.println(dao.buscarPorId(id));
            }
            case 4 -> {
                System.out.print("ID a actualizar: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("Tipo: ");
                String tipo = sc.nextLine();
                System.out.print("Ubicación: ");
                String u = sc.nextLine();
                System.out.print("Precio: ");
                double p = sc.nextDouble();
                System.out.print("Habitaciones: ");
                int h = sc.nextInt();
                System.out.print("ID Propietario: ");
                int idp = sc.nextInt();
                System.out.print("ID Inmobiliaria: ");
                int idi = sc.nextInt();

                dao.actualizar(new Propiedad(id, tipo, u, p, h, idp, idi));
            }
            case 5 -> {
                System.out.print("ID a eliminar: ");
                int id = sc.nextInt();
                dao.eliminar(id);
            }
        }
    }

    // ================================
    //   MENU PUBLICACION
    // ================================
    private static void menuPublicacion() {
        PublicacionDAO dao = new PublicacionDAO();
        System.out.println("------ PUBLICACIONES ------");
        System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Buscar por ID");
        System.out.println("4. Actualizar");
        System.out.println("5. Eliminar");
        System.out.print("Opción: ");
        int op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("ID Propiedad: ");
                int idp = sc.nextInt();
                System.out.print("ID Usuario: ");
                int idu = sc.nextInt(); sc.nextLine();
                System.out.print("Estado: ");
                String e = sc.nextLine();
                System.out.print("Fecha (YYYY-MM-DD): ");
                Date f = Date.valueOf(sc.nextLine());
                System.out.print("Descripción: ");
                String d = sc.nextLine();

                dao.insertar(new Publicacion(0, idp, idu, e, f, d));
            }
            case 2 -> dao.listar().forEach(System.out::println);
            case 3 -> {
                System.out.print("ID: ");
                int id = sc.nextInt();
                System.out.println(dao.buscarPorId(id));
            }
            case 4 -> {
                System.out.print("ID a actualizar: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("ID Propiedad: ");
                int idp = sc.nextInt();
                System.out.print("ID Usuario: ");
                int idu = sc.nextInt(); sc.nextLine();
                System.out.print("Estado: ");
                String e = sc.nextLine();
                System.out.print("Fecha (YYYY-MM-DD): ");
                Date f = Date.valueOf(sc.nextLine());
                System.out.print("Descripción: ");
                String d = sc.nextLine();

                dao.actualizar(new Publicacion(id, idp, idu, e, f, d));
            }
            case 5 -> {
                System.out.print("ID a eliminar: ");
                int id = sc.nextInt();
                dao.eliminar(id);
            }
        }
    }

    // ================================
    //   MENU HISTORIAL
    // ================================
    private static void menuHistorial() {
        HistorialPublicacionDAO dao = new HistorialPublicacionDAO();
        System.out.println("------ HISTORIAL ------");
        System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Buscar por ID");
        System.out.println("4. Actualizar");
        System.out.println("5. Eliminar");
        System.out.print("Opción: ");
        int op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("ID Cliente: ");
                int idc = sc.nextInt();
                System.out.print("ID Publicación: ");
                int idp = sc.nextInt(); sc.nextLine();
                System.out.print("Fecha (YYYY-MM-DD): ");
                Date f = Date.valueOf(sc.nextLine());

                dao.insertar(new HistorialPublicacion(0, idc, idp, f));
            }
            case 2 -> dao.listar().forEach(System.out::println);
            case 3 -> {
                System.out.print("ID: ");
                int id = sc.nextInt();
                System.out.println(dao.buscarPorId(id));
            }
            case 4 -> {
                System.out.print("ID Historial: ");
                int id = sc.nextInt();
                System.out.print("ID Cliente: ");
                int idc = sc.nextInt();
                System.out.print("ID Publicación: ");
                int idp = sc.nextInt(); sc.nextLine();
                System.out.print("Fecha (YYYY-MM-DD): ");
                Date f = Date.valueOf(sc.nextLine());

                dao.actualizar(new HistorialPublicacion(id, idc, idp, f));
            }
            case 5 -> {
                System.out.print("ID: ");
                int id = sc.nextInt();
                dao.eliminar(id);
            }
        }
    }

    // ================================
    //   MENU COMPRA
    // ================================
    private static void menuCompra() {
        CompraDAO dao = new CompraDAO();
        System.out.println("------ COMPRAS ------");
        System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Buscar por ID");
        System.out.println("4. Actualizar");
        System.out.println("5. Eliminar");
        System.out.print("Opción: ");
        int op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Fecha (YYYY-MM-DD): ");
                Date f = Date.valueOf(sc.nextLine());
                System.out.print("Monto: ");
                double m = sc.nextDouble();
                System.out.print("ID Cliente: ");
                int idc = sc.nextInt();
                System.out.print("ID Propiedad: ");
                int idp = sc.nextInt();

                dao.insertar(new Compra(0, f, m, idc, idp));
            }
            case 2 -> dao.listar().forEach(System.out::println);
            case 3 -> {
                System.out.print("ID: ");
                int id = sc.nextInt();
                System.out.println(dao.buscarPorId(id));
            }
            case 4 -> {
                System.out.print("ID compra: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("Fecha (YYYY-MM-DD): ");
                Date f = Date.valueOf(sc.nextLine());
                System.out.print("Monto: ");
                double m = sc.nextDouble();
                System.out.print("ID Cliente: ");
                int idc = sc.nextInt();
                System.out.print("ID Propiedad: ");
                int idp = sc.nextInt();

                dao.actualizar(new Compra(id, f, m, idc, idp));
            }
            case 5 -> {
                System.out.print("ID: ");
                int id = sc.nextInt();
                dao.eliminar(id);
            }
        }
    }

    // ================================
    //   MENU CONTRATO
    // ================================
    private static void menuContrato() {
        ContratoDAO dao = new ContratoDAO();
        System.out.println("------ CONTRATOS ------");
        System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Buscar por ID");
        System.out.println("4. Actualizar");
        System.out.println("5. Eliminar");
        System.out.print("Opción: ");
        int op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Fecha inicio (YYYY-MM-DD): ");
                Date fi = Date.valueOf(sc.nextLine());
                System.out.print("Fecha fin (YYYY-MM-DD): ");
                Date ff = Date.valueOf(sc.nextLine());
                System.out.print("Términos: ");
                String t = sc.nextLine();
                System.out.print("ID Compra: ");
                int idc = sc.nextInt();

                dao.insertar(new Contrato(0, fi, ff, t, idc));
            }
            case 2 -> dao.listar().forEach(System.out::println);
            case 3 -> {
                System.out.print("ID: ");
                int id = sc.nextInt();
                System.out.println(dao.buscarPorId(id));
            }
            case 4 -> {
                System.out.print("ID contrato: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("Fecha inicio (YYYY-MM-DD): ");
                Date fi = Date.valueOf(sc.nextLine());
                System.out.print("Fecha fin (YYYY-MM-DD): ");
                Date ff = Date.valueOf(sc.nextLine());
                System.out.print("Términos: ");
                String t = sc.nextLine();
                System.out.print("ID Compra: ");
                int idc = sc.nextInt();

                dao.actualizar(new Contrato(id, fi, ff, t, idc));
            }
            case 5 -> {
                System.out.print("ID: ");
                int id = sc.nextInt();
                dao.eliminar(id);
            }
        }
    }

}
