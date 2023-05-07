package com.mycompany.inicio;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Inicio {
    
    private static Map<String, String> usuarios = new HashMap<>();
    private static String usuarioActual = null;

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Bienvenido al sistema de registro e inicio de sesión:");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Cerrar sesión");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");

            int opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar el búfer del teclado

            switch (opcion) {
                case 1:
                    registrarUsuario(teclado);
                    break;
                case 2:
                    iniciarSesion(teclado);
                    break;
                case 3:
                    cerrarSesion();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }

            System.out.println();
        }

        teclado.close();
    }

    private static void registrarUsuario(Scanner scanner) {
        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.nextLine();

        if (usuarios.containsKey(usuario)) {
            System.out.println("El nombre de usuario ya existe. Por favor, elija otro.");
        } else {
            System.out.print("Ingrese su contraseña: ");
            String contraseña = scanner.nextLine();
            usuarios.put(usuario, contraseña);
            System.out.println("Registro exitoso. Ahora puede iniciar sesión.");
        }
    }

    private static void iniciarSesion(Scanner scanner) {
        if (usuarioActual != null) {
            System.out.println("Ya has iniciado sesión como " + usuarioActual);
            return;
        }

        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.nextLine();

        if (!usuarios.containsKey(usuario)) {
            System.out.println("El nombre de usuario no existe. Por favor, regístrese.");
        } else {
            System.out.print("Ingrese su contraseña: ");
            String contraseña = scanner.nextLine();

            if (usuarios.get(usuario).equals(contraseña)) {
                usuarioActual = usuario;
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + usuarioActual + "!");
            } else {
                System.out.println("Contraseña incorrecta. Por favor, intente nuevamente.");
            }
        }
    }

    private static void cerrarSesion() {
        if (usuarioActual == null) {
            System.out.println("No has iniciado sesión.");
        } else {
            System.out.println("Cerrando sesión de " + usuarioActual);
            usuarioActual = null;
        }
    }
}
