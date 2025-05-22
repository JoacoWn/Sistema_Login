package logica;

import datos.DatosLogin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    private Login login;
    private DatosLogin datos;

    @BeforeEach
    void setUp() {
        login = new Login();
        datos = new DatosLogin();
    }

    @Test
    void loginValido() {
        boolean resultado = login.autenticar("xiao", "ola123", datos);
        // Assert: comprobar que el resultado es true
        assertTrue(resultado, "El login debería ser exitoso con credenciales correctas");
    }

    @Test
    void usuarioInexistente() {
        boolean resultado = login.autenticar("joaco", "bruuuuu", datos);
        // Assert: comprobar que el resultado es true
        assertFalse(resultado, "El login debería ser incorrecto con credenciales incorrectas");
    }
    @Test
    void contraseñaIncorrecta() {
        boolean resultado = login.autenticar("xiao", "chavez", datos);
        // Assert: comprobar que el resultado es true
        assertFalse(resultado, "El login debería ser incorrecto con usuario corecto, y contraseña incorrectas");
    }

    @Test
    void archivoNoEncontrado() throws IOException {
        assertThrows(IOException.class, () -> { new DatosLogin("ruta/inexistente.txt");
        }, "Debe lanzar IOException si el archivo no existe");
    }
}