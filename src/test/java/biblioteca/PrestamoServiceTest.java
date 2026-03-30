package biblioteca;

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
    void testCodigoLibroInvalido() {
        String resultado = service.validarCodigoLibro("ABC123");
        assertEquals("Ingrese un código de libro válido", resultado);
    }





















}