package biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrestamoServiceTest {


    private PrestamoService service = new PrestamoService();

    @Test
    void testCodigoPrestamoInvalido_FormatoIncorrecto() {
        // Arrange
        String codigoPrestamo = "abc123";

        // Act
        String resultado = service.validarCodigoPrestamo(codigoPrestamo);

        // Assert
        assertEquals("Ingrese un código de préstamo válido", resultado);
    }

}