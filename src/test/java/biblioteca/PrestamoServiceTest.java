package biblioteca;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrestamoServiceTest {

    private PrestamoService service = new PrestamoService();

    @Test
    void testCodigoPrestamoInvalido_FormatoIncorrecto() {
        // Probar con código inválido (debe fallar inicialmente)
        String resultado = service.validarCodigoPrestamo("abc123");
        assertEquals("Ingrese un código de préstamo válido", resultado);
    }

    @Test
    @DisplayName("Código de préstamo con formato correcto")
    void testCodigoLibroInvalido() {
        String resultado = service.validarCodigoLibro("ABC123");
        assertEquals("Ingrese un código de libro válido", resultado);
    }


    @Test
    @DisplayName("Nombre de usuario con menos de 4 caracteres")
    void testNombreUsuarioInvalido_MenosDe4Caracteres() {
        String resultado = service.validarNombreUsuario("Ana");
        assertEquals("El nombre del usuario debe tener al menos cuatro caracteres alfabéticos",
                resultado);
    }

    @Test
    void testNombreUsuarioInvalido_ConNumeros() {
        String resultado = service.validarNombreUsuario("Maria123");
        assertEquals("El nombre del usuario debe tener al menos cuatro caracteres alfabéticos",
                resultado);
    }

    @Test
    @DisplayName("Fecha de préstamo en el futuro")
    void testFechaPrestamoInvalida_Futura() {
        LocalDate fechaFutura = LocalDate.now().plusDays(1);
        String resultado = service.validarFechaPrestamo(fechaFutura);
        assertEquals("Ingrese una fecha de préstamo válida", resultado);
    }


    @Test
    void testFechaDevolucionInvalida_MenorOIgual() {
        LocalDate fechaPrestamo = LocalDate.now();
        LocalDate fechaDevolucion = LocalDate.now(); // Mismo día (inválido)
        String resultado = service.validarFechaDevolucion(fechaPrestamo, fechaDevolucion);
        assertEquals("La fecha de devolución debe ser posterior a la fecha de préstamo",
                resultado);
    }
















}