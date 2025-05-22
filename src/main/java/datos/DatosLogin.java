package datos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DatosLogin {
    public ArrayList<String> credenciales = new ArrayList<>();

    // Constructor por defecto (usa ruta relativa)
    public DatosLogin() {
        cargarUsuarios("src/login.txt");
    }

    // Constructor con ruta personalizada
    public DatosLogin(String rutaArchivo) {
        cargarUsuarios(rutaArchivo);
    }

    // Método modificado para aceptar ruta
    private void cargarUsuarios(String rutaArchivo) {
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {

            String linea;

            while ((linea = lector.readLine()) != null) {
                linea = linea.trim();

                if (linea.contains(";")) {

                    String[] partes = linea.split(";");
                    if (partes.length == 2) {
                        credenciales.add(linea);
                        System.out.println("Línea válida: " + linea);
                    }
                }
                else if (!linea.isEmpty()) {
                    System.out.println("Línea ignorada: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}