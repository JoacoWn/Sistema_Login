package ui;
import datos.DatosLogin;
import logica.Login;

import java.util.Scanner;

/**
 * Clase responsable de interactuar con el usuario por consola.
 * Controla el menú principal y el flujo de login.
 */
public class ConsolaLogin {
    Scanner scanner = new Scanner(System.in);
    DatosLogin datos = new DatosLogin();
    Login login = new Login();

    /**
     * Controla el ciclo principal del menú del sistema.
     */
    public void menu() {
        String opcion;
        do {
            mostrarOpciones();
            opcion = scanner.nextLine();
            if (!opcion.equals("2")) {
                ejecutarOpcion(opcion);
            }
        } while (!opcion.equals("2"));
        System.out.println("Saliendo del programa...");
    }

    /**
     * Muestra las opciones disponibles para el usuario.
     */
    private void mostrarOpciones() {
        System.out.println("=============================");
        System.out.println("          SISTEMA LOGIN      ");
        System.out.println("=============================");
        System.out.println("    [1] Iniciar sesión");
        System.out.println("    [2] Salir");
        System.out.println("=============================");
        System.out.print("      Opción: ");
    }

    /**
     * Ejecuta la opción seleccionada por el usuario.
     *
     * @param opcion opción ingresada por el usuario
     */
    private void ejecutarOpcion(String opcion) {
        switch (opcion) {
            case "1" -> manejarLogin();
            default -> System.out.println("Opción inválida...");
        }
    }

    /**
     * Solicita usuario y contraseña, y muestra el resultado.
     */
    private void manejarLogin() {
        System.out.print("Ingrese usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String contrasena = scanner.nextLine();

        boolean autenticado = login.autenticar(usuario, contrasena, datos);
        if (autenticado) {
            System.out.println("Login exitoso!");
        } else {
            System.out.println("Credenciales incorrectas. Intente nuevamente.");
        }
    }
}